package AES;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import com.sun.org.apache.bcel.internal.classfile.Field;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class GUI implements ActionListener{
	AES_base128 aes;
	JFrame frame=new JFrame("AES128");
    JButton encryptButton =new JButton("加密");
    JButton decryptButton=new JButton("解密");
    JButton importButton=new JButton("导入");
    JButton exportButton=new JButton("导出");
    JLabel keyJLabel=new JLabel("16位密钥：",SwingConstants.LEFT);
    JTextField keyField=new JTextField(15);
    JTextArea cleartext;
    JTextArea ciphertext;
	public GUI(){
		aes=new AES_base128();
		
		frame.setSize(600,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JPanel panel=new JPanel();
        JPanel panel1=new JPanel();
        
        keyJLabel.setBounds(0, 0, 15, 2);
        keyField.setBounds(0, 16, 16, 2);
        
        keyField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if(keyField.getText().length()>=16)
					e.consume();
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        panel1.add(keyJLabel);
        panel1.add(keyField);
        
        JPanel panel2=new JPanel();
        panel2.setBorder(BorderFactory.createTitledBorder("明文"));
        cleartext=new JTextArea(9,45);
        cleartext.setLineWrap(true);
        JScrollPane scroll1=new JScrollPane(cleartext);
        scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel2.add(scroll1);

        JPanel panel3=new JPanel();
        panel3.setBorder(BorderFactory.createTitledBorder("密文"));
        ciphertext=new JTextArea(9,45);
        ciphertext.setLineWrap(true);
        JScrollPane scroll2=new JScrollPane(ciphertext);
        scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel3.add(scroll2);
        
        panel1.add(encryptButton);
        panel1.add(decryptButton);
        
        
        
        
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(importButton);
        panel.add(exportButton);
        
        
        
        frame.add(panel);
        
        encryptButton.addActionListener(this);
        decryptButton.addActionListener(this);
        importButton.addActionListener(this);
        exportButton.addActionListener(this);
        frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==encryptButton){
			String key=keyField.getText();
			if(key.length()!=16){
				JOptionPane.showMessageDialog(null,"密钥必须要是16位","Warning",JOptionPane.ERROR_MESSAGE);
			}
			else{
				try{
			    aes.setSkey(key);
				String clear=cleartext.getText();
				ciphertext.setText(aes.encrypt(clear));
				}catch (Exception E) {
					// TODO: handle exception
					E.printStackTrace();
				}
			}
			
		}
		if(e.getSource()==decryptButton){
			String key=keyField.getText();
			if(key.length()!=16){
				JOptionPane.showMessageDialog(null,"密钥必须要是16位","Warning",JOptionPane.ERROR_MESSAGE);
			}
			else{
				try{
			    aes.setSkey(key);
				String cipher=ciphertext.getText();
				cleartext.setText(aes.decrypt(cipher));
				}catch (Exception E) {
					// TODO: handle exception
					E.printStackTrace();
				}
			}
		}
		if(e.getSource()==importButton){
			JFileChooser fileChooser=new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.showDialog(new JLabel(), "导入密文");
			File file=fileChooser.getSelectedFile();
			try{
			FileReader reader=new FileReader(file);
			BufferedReader bufferedReader=new BufferedReader(reader);
			StringBuffer buffer=new StringBuffer();
			String tempString;
			while((tempString=bufferedReader.readLine())!=null){
				buffer.append(tempString);
			}
			ciphertext.setText(buffer.toString());
			}catch (Exception E) {
				// TODO: handle exception
				E.printStackTrace();
			}
			
		}
		if(e.getSource()==exportButton){
			JFileChooser fileChooser=new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			int select=fileChooser.showSaveDialog(frame);
			BufferedWriter bw=null;
			File file=null;
			String fileName=null;
			if(select==JFileChooser.APPROVE_OPTION){
				file=fileChooser.getSelectedFile();
			}
			//fileChooser.showDialog(new JLabel(), "导入密文");
			fileName = fileChooser.getName(file);
            if(fileName==null|| fileName.trim().length()==0){
                JOptionPane.showMessageDialog(null, "文件名为空！");
            }
            
            if(file.isFile()){
                fileName = file.getName();
            }
            //否则是个文件夹
            file = fileChooser.getCurrentDirectory();//获得当前目录
            
            String path = file.getPath()+java.io.File.separator+fileName;
            file =new File(path);
        
             if(file.exists()) {  //若选择已有文件----询问是否要覆盖   
                 int i = JOptionPane.showConfirmDialog(null, "该文件已经存在，确定要覆盖吗？");     
                 if(i == JOptionPane.YES_OPTION)   ;     
                 else   return ;    
                 }
             try {
                 bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                 bw.write(ciphertext.getText());
                 bw.flush();
             } catch (FileNotFoundException e1) {
                 JOptionPane.showMessageDialog(null, "文件保存出错"+e1.getMessage());
             } catch (IOException e1) {
                 e1.printStackTrace();
             }finally{
                 try {
                     if(bw!=null) bw.close();
                 } catch (IOException e1) {
                 }
             }
		}
		
	}
	public static void main(String[] args){
		new GUI();
	}

}
