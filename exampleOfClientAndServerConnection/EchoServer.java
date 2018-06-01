package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;



public class EchoServer {
	public static void main(String[] args){
	//启动服务器
     ServerSocket listenSocket=null;
     Socket clienSocket=null;
     BufferedReader in=null;
     BufferedWriter out=null;
     try{
    	 listenSocket=new ServerSocket();
    	 SocketAddress serverAddress=new InetSocketAddress("localhost",5000);
    	 listenSocket.bind(serverAddress);
    	 System.out.println("1.服务器启动成功！开始在localhost的5000端口侦听连接。。。");
    	 
    	 //处理连接
    	 clienSocket=listenSocket.accept();
    	 System.out.println("2.客户机连接成功！客户机地址和端口："+clienSocket.getRemoteSocketAddress());
    	 
    	 //与客户机会话
    	 in=new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));
    	 out=new BufferedWriter(new OutputStreamWriter(clienSocket.getOutputStream()));
    	 String receiveString=in.readLine();  //从客户机接收字符串
    	 System.out.println("3.1 服务器收到字符串:"+receiveString);
    	 out.write(receiveString);;
    	 out.newLine();
    	 out.flush();
    	 System.out.println("3.2 服务器回送字符串成功："+receiveString);
    	 
    	 
     }catch(Exception e){
    	 System.out.println(e.getMessage());
    	 e.printStackTrace();
     }
     try{
    	 if(in!=null)
    		 in.close();
    	 if(out!=null)
    		 out.close();
    	 if(listenSocket!=null)
    		 listenSocket.close();
    	 if(clienSocket!=null)
    		 clienSocket.close();
    	 System.out.println("4. 关闭套接字和流成功");
    	 
     }catch (IOException e) {
		System.out.println(e.getMessage());
	}
   }
}
