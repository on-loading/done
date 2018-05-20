package AES;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Base64;

import javax.crypto.Cipher;  
import javax.crypto.spec.IvParameterSpec;  
import javax.crypto.spec.SecretKeySpec;
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

import com.sun.glass.ui.Window;
import com.sun.javafx.applet.ExperimentalExtensions;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import sun.nio.ch.WindowsAsynchronousChannelProvider;
public class AES_base128 implements ActionListener{
	  /*
	    * 加密用的Key 可以用26个字母和数字组成
	    * 此处使用AES-128-CBC加密模式，key需要为16位。
	    */
	    private String sKey = "0123456789abcdef";
	    private String ivParameter = "0123456789abcdef";
	    private static AES_base128 instance = null;

	    AES_base128() {

	    }
 
	    public void setSkey(String s){
	    	sKey=s;
	    }
	    public static AES_base128 getInstance() {
	        if (instance == null)
	            instance = new AES_base128();
	        return instance;
	    }

	    // 加密
	    public String encrypt(String sSrc) throws Exception {
	        Cipher cipher = Cipher.getInstance("AES / CBC / PKCS5Padding");
	        byte[] raw = sKey.getBytes();
	        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
	        IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
	        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
	        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
	        return new BASE64Encoder().encode(encrypted);//此处使用BASE64做转码。
	    }

	    // 解密
	    public String decrypt(String sSrc) throws Exception {
	        try {
	            byte[] raw = sKey.getBytes("ASCII");
	            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
	            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	            IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
	            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
	            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);//先用base64解密
	            byte[] original = cipher.doFinal(encrypted1);
	            String originalString = new String(original, "utf-8");
	            return originalString;
	        } catch (Exception ex) {
	            return null;
	        }
	    }

//	    public static void main(String[] args) throws Exception {
//	// 需要加密的字串
//	        String cSrc = "我来自www.wenhq.com";
//	        System.out.println(cSrc);
//	// 加密
//	        long lStart = System.currentTimeMillis();
//	        String enString = AES_base128.getInstance().encrypt(cSrc);
//	        System.out.println("加密后的字串是：" + enString);
//
//	        long lUseTime = System.currentTimeMillis() - lStart;
//	        System.out.println("加密耗时：" + lUseTime + "毫秒");
//	// 解密
//	        lStart = System.currentTimeMillis();
//	        String DeString = AES_base128.getInstance().decrypt(enString);
//	        System.out.println("解密后的字串是：" + DeString);
//	        lUseTime = System.currentTimeMillis() - lStart;
//	        System.out.println("解密耗时：" + lUseTime + "毫秒");
//	        
//	        GUI uGui=new GUI();
	        
//	        JFrame frame=new JFrame("AES128");
//	        frame.setSize(600,500);
//	        frame.setLocationRelativeTo(null);
//	        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//	        JPanel panel=new JPanel();
//	        JPanel panel1=new JPanel();
//	        JLabel keyJLabel=new JLabel("128位密钥：",SwingConstants.LEFT);
//	        JTextField keyField=new JTextField(15);
//	        JButton encryptButton =new JButton("加密");
//	        JButton decryptButton=new JButton("解密");
//	        
//
//	        keyJLabel.setBounds(0, 0, 15, 2);
//	        keyField.setBounds(0, 16, 16, 2);
//	        panel1.add(keyJLabel);
//	        panel1.add(keyField);
//	        
//	        
//	        
//	        JPanel panel2=new JPanel();
//	        panel2.setBorder(BorderFactory.createTitledBorder("明文"));
//	        JTextArea cleartext=new JTextArea(9,45);
//	        cleartext.setLineWrap(true);
//	        JScrollPane scroll1=new JScrollPane(cleartext);
//	        scroll1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//	        panel2.add(scroll1);
//
//	        JPanel panel3=new JPanel();
//	        panel3.setBorder(BorderFactory.createTitledBorder("密文"));
//	        JTextArea ciphertext=new JTextArea(9,45);
//	        ciphertext.setLineWrap(true);
//	        JScrollPane scroll2=new JScrollPane(ciphertext);
//	        scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//	        panel3.add(scroll2);
//	        
//	        JButton importButton=new JButton("导入");
//	        JButton exportButton=new JButton("导出");
//	        
//	        importButton.addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					// TODO Auto-generated method stub
//					JFileChooser fileChooser=new JFileChooser("导入文件");
//					fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
//					fileChooser.showDialog(new JLabel(), "导入");
//				}
//			});
//	        encryptButton.addMouseListener(new MouseListener() {
//				@Override
//				public void mouseClicked(MouseEvent e){
//					String key=keyField.getText();
//					if(key.length()!=16){
//						JOptionPane.showMessageDialog(null,"密钥必须要是16位","Warning",JOptionPane.ERROR_MESSAGE);
//					}
//					else{
//						try{
//					    AES_base128.instance.setSkey(key);
//						String clear=cleartext.getText();
//						ciphertext.setText(AES_base128.getInstance().encrypt(clear));
//						}catch (Exception E) {
//							// TODO: handle exception
//							E.printStackTrace();
//						}
//					}
//				}
//				public void mousePressed(MouseEvent e) {}
//				public void mouseReleased(MouseEvent e) {}
//				public void mouseEntered(MouseEvent e) {}
//				public void mouseExited(MouseEvent e) {}
//			});
//	        
//	        decryptButton.addMouseListener(new MouseListener() {
//				@Override
//				public void mouseClicked(MouseEvent e){
//					String key=keyField.getText();
//					if(key.length()!=16){
//						JOptionPane.showMessageDialog(null,"密钥必须要是16位","Warning",JOptionPane.ERROR_MESSAGE);
//					}
//					else{
//						try{
//					    AES_base128.instance.setSkey(key);
//						String cipher=ciphertext.getText();
//						cleartext.setText(AES_base128.getInstance().decrypt(cipher));
//						}catch (Exception E) {
//							// TODO: handle exception
//							E.printStackTrace();
//						}
//					}
//				}
//				public void mousePressed(MouseEvent e) {}
//				public void mouseReleased(MouseEvent e) {}
//				public void mouseEntered(MouseEvent e) {}
//				public void mouseExited(MouseEvent e) {}
//	        });
//	        keyField.addKeyListener(new KeyListener() {	
//				@Override
//				public void keyTyped(KeyEvent e) {
//					if(keyField.getText().length()>=16)
//						e.consume();
//				}
//				public void keyReleased(KeyEvent e) {}
//				public void keyPressed(KeyEvent e) {}
//			});
//	        panel1.add(encryptButton);
//	        panel1.add(decryptButton);
//	        
//	        
//	        
//	        
//	        panel.add(panel1);
//	        panel.add(panel2);
//	        panel.add(panel3);
//	        panel.add(importButton);
//	        panel.add(exportButton);
//	        frame.add(panel);
//	       // frame.add(panel1);
//	        frame.setVisible(true);
	        
	    //}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//if(e.getSource()==importButton)
		}
}
