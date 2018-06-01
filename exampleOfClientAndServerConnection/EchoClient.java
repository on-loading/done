package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class EchoClient {
	public static void main(String[] args){
	     Socket clienSocket=null;
	     BufferedReader in=null;
	     BufferedWriter out=null;
	     try{
	    	 //创建客户机套接字
	    	 clienSocket=new Socket();
	    	 SocketAddress serverAddress=new InetSocketAddress("localhost",5000);
	    	 System.out.println("1.创建客户机套接字成功。");
	    	 
	    	 //连接服务器
	    	 clienSocket.connect(serverAddress);
	    	 System.out.println("2.客户机连接服务器localhost端口5000成功！");
	    	 System.out.println("客户机地址和端口："+clienSocket.getLocalSocketAddress());
	    	 
	    	 //与服务器会话
	    	 in=new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));
	    	 out=new BufferedWriter(new OutputStreamWriter(clienSocket.getOutputStream()));
	    	 String sendString="这是客户机发送的字符串";  
	    	 out.write(sendString);   //向服务器发送字符串
	    	 out.newLine();
	    	 out.flush();
	    	 System.out.println("3.1 向服务器发送字符串成功："+sendString);
	    	 String receivesString=in.readLine();  //从服务器接收字符串
	    	 System.out.println("3.2 从服务器接收字符成功："+receivesString);
	    	 
	     }catch(Exception e){
	    	 System.out.println(e.getMessage());
	    	 e.printStackTrace();
	     }
	     try{
	    	 if(in!=null)
	    		 in.close();
	    	 if(out!=null)
	    		 out.close();
	    	 if(clienSocket!=null)
	    		 clienSocket.close();
	    	 System.out.println("4. 关闭套接字和流成功");
	    	 
	     }catch (IOException e) {
			System.out.println(e.getMessage());
		}
	   }
}
