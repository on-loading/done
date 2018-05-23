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
public class AES_base128 {
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


}
