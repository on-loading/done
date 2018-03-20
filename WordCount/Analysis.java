package homework;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;


public class Analysis {
      private String rootPath="src\\homework\\";
      private String resultFile="result.txt";
      private String file_name="";
      private String output;
      private String stopList;
      private int wordCount;
      private int lineCount;
      private int characterCount;
      private int codeLine;
      private int noteLine;
      private int emptyLine;
      public boolean cFlag=false;
      public boolean lFlag=false;
      public boolean wFlag=false;
      public boolean eFlag=false;
      public boolean aFlag=false;
      public boolean sFlag=false;
      public boolean oFlag=false;
      public boolean batchFlag=true;   //用一个flag控制批量运行不会无限循环
      ArrayList<File> fileList=null;
      int level=0;
      

	public  int countCharacter(String fileName){  //统计字符数
		//File file=new File(rootPath+fileName);
		File file=new File(fileName);
		if(!file.exists()){
			return 0;
		}
		int count=0;
		InputStream inputStream=null;
		try{
			inputStream=new FileInputStream(file);
			int temp=0;
			while((temp=inputStream.read())!=-1){
				if(temp!=13 && temp!=10)  //把回车和换行符排除掉
				   count++;
			}
			inputStream.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		characterCount=count;
		//System.out.println(fileName+",字符数："+characterCount);
		writeC(fileName, resultFile);
		return characterCount;
	}
	public void writeC(String fileName,String output){
		try{
			//File file =new File(rootPath+output);
			File file=new File(output);
			if(!file.exists())
				file.createNewFile();
			BufferedWriter writer=new BufferedWriter(new FileWriter(file,true));
			writer.newLine();
			writer.write(fileName+"，字符数："+characterCount);
			writer.close();
		}catch(IOException e){
			e.printStackTrace();;
		}
	}
	public  int countLine(String fileName){   //统计行数
		//File file=new File(rootPath+fileName);
		File file=new File(fileName);
		if(!file.exists()){
			return 0;
		}
		int  count=0;
		BufferedReader reader=null;
		try{
			reader=new BufferedReader(new FileReader(file));
			while(reader.readLine()!=null){
				   count++;
			}
			reader.close();
		}catch(IOException e){
			e.printStackTrace();
		}
        lineCount=count;
        //System.out.println(fileName+",行数："+lineCount);
        writeL(fileName, resultFile);
        return lineCount;
	}
	
	public void writeL(String fileName,String output){
		try{
			//File file =new File(rootPath+output);
			File file=new File(output);
			if(!file.exists())
				file.createNewFile();
			BufferedWriter writer=new BufferedWriter(new FileWriter(file,true));
			writer.newLine();
			writer.write(fileName+"，行数："+lineCount);
			writer.close();
		}catch(IOException e){
			e.printStackTrace();;
		}
	}
	public int countWord(String fileName){   //统计单词数
		//File file=new File(rootPath+fileName);
		File file=new File(fileName);
		if(!file.exists()){
			return 0;
		}
		int count=0;
		BufferedReader reader=null;
		try{
			reader=new BufferedReader(new FileReader(file));
			int pre=10;
			int temp=0;
			while((temp=reader.read())!=-1){
				if(temp==44 || temp==32 || temp==10 || temp==13){   //如果遇到空格或者逗号
					if(pre!=10 && pre!=13 && pre!=44 && pre!=32){  //判断前一个字符是不是空格、回车、换行、逗号
					  count++;
					}
				}
				pre=temp;
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		wordCount=count;
		System.out.println(fileName+",单词数："+wordCount);
		writeW(fileName, resultFile);
		return wordCount;
	}
	public void writeW(String fileName,String output){
		try{
			//File file =new File(rootPath+output);
			File file=new File(output);
			if(!file.exists())
				file.createNewFile();
			BufferedWriter writer=new BufferedWriter(new FileWriter(file,true));
			writer.newLine();
			writer.write(fileName+"，单词数："+wordCount);
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public  void  writeFile(String fileName,String outputResult){  //输出到文件中
		//File file=new File(rootPath+outputResult);
		File file=new File(outputResult);
		if(!file.exists()){
			try{
				file.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		try{
			BufferedWriter writer=new BufferedWriter(new FileWriter(file,true));
			writer.flush();
			writer.newLine();
			writer.write(fileName+"，字符数："+characterCount);
			writer.newLine();
			writer.write(fileName+"，单词数："+wordCount);
			writer.newLine();
			if(aFlag)
				writer.write(fileName+"，代码行/空行/注释行："+codeLine+"/"+emptyLine+"/"+noteLine);
			else
			   writer.write(fileName+"，行数："+lineCount);
			
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void batchProcessing(String filename,String subPath,ArrayList<String> commandList){
		level++;
		try{
			File file=new File(rootPath+subPath);
			fileList.addAll(Arrays.asList(file.listFiles()));
		    for(File f:fileList){
		    	if(f.isDirectory()){
		    		String str=f.getName();
		    		fileList.remove(f);
		    		batchProcessing(filename,subPath+"\\"+str,commandList);  //进入下一级目录
		    	}
		    	if(!f.getName().endsWith(filename.substring(1)))
		    		fileList.remove(f);
		    }
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		if(level==1){
			for(File f:fileList){
				file_name=f.getName();
				doWork(commandList);
			}
		}
		level--;
	}
	public void differentLine(String fileName){
	     //File file=new File(rootPath+fileName);
	     File file=new File(fileName);
	     emptyLine=0;
	     codeLine=0;
	     noteLine=0;
	     try{
		     BufferedReader reader=new BufferedReader(new FileReader(file));
		     String str;
		     while((str=reader.readLine())!=null){
		    	 String[] wordlist=str.split(" ");
		    	 if(wordlist.length==0)
		    		 emptyLine++;   //没有字符的行属于空行
		    	 else{
		    		 if(wordlist.length==1 && wordlist[0].length()==1)
		    			 emptyLine++;   //一行只有一个字符，属于空行
		    		 else if(wordlist[0].length()>=2 && wordlist[0].charAt(0)=='/' && wordlist[0].charAt(1)=='/')
		    			 noteLine++;   //以双斜杠“\\”开头的属于注释行
		    		 else if(wordlist[0].length()==1 && wordlist.length>=2 && wordlist[1].length()>=2 
		    				 && wordlist[0].charAt(0)=='/' && wordlist[0].charAt(1)=='/')
		    			 noteLine++;     //遇到  “ }   //....."的情况属于注释行
		    		 else if(wordlist[0].length()>=3 && wordlist[0].charAt(1)=='/' && wordlist[0].charAt(2)=='/')
		    			 noteLine++;    //遇到" }//.....   "也是注释行
		    		 else {
						codeLine++;
					}
		    	 }
		     }
		     
	     }catch(IOException e){
	    	 e.printStackTrace();
	     }
		
	}
	public void putLine(String outputf){
		System.out.println("代码行/空行/注释行："+codeLine+"/"+emptyLine+"/"+noteLine);
		try{
			//File file =new File(rootPath+outputf);
			File file=new File(outputf);
			if(!file.exists())
				file.createNewFile();
			BufferedWriter writer=new BufferedWriter(new FileWriter(file,true));
			writer.newLine();
			writer.write(file_name+"，代码行/空行/注释行："+codeLine+"/"+emptyLine+"/"+noteLine);
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	//获取停用词表
	public ArrayList<String> getStopList(String fileName){
		//File file=new File(rootPath+fileName);
		File file=new File(fileName);
		ArrayList<String> list=new ArrayList<String>();
		try{
			if(!file.exists())
				return null;
			BufferedReader reader=new BufferedReader(new FileReader(file));
			String str=null;
			
			while((str=reader.readLine())!=null){
				if(str=="\r" || str=="\n")
					continue;
				String[] s=str.split("\\s+");
				for(String ss:s){
					if(ss!="\n" && ss!="\r" )
						list.add(ss);
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
			
		}
		return list;
	}
	public void countWordWithS(String fileName,String stopList){  //在stopList的基础上统计单词
		//先获取stoplist中的词
		//File stopfile=new File(rootPath+stopList);
		File stopfile=new File(stopList);
		ArrayList<String> list=new ArrayList<String>();
		try{
			BufferedReader reader=new BufferedReader(new FileReader(stopfile));
			String str=null;
			
			while((str=reader.readLine())!=null){
				if(str=="\r" || str=="\n")
					continue;
				String[] s=str.split("\\s+");
				for(String ss:s){
					if(ss!="\n" && ss!="\r" )
						list.add(ss);
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
			
		}
		
		
		//统计除了stoplist之外的单词数量
		//File file=new File(rootPath+fileName);
		File file=new File(fileName);
		int count=0;
		try{
//			if(!file.exists())
//				return 0;
			BufferedReader reader=new BufferedReader(new FileReader(file));
			String str=null;
			
			while((str=reader.readLine())!=null){
				if(str=="\r" || str=="\n")
					continue;
				String[] s=str.split("\\s+|,");
				for(String ss:s){
					if(!list.contains(ss))
						count++;
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
			
		}
		wordCount=count;
		writeW(fileName, resultFile);
		//return count;
	}

	public void doWork(ArrayList<String> commandList){
		if(commandList.contains("-s")){
			commandList.remove("-s");
			sFlag=true;
		}
		if(commandList.contains("-e")){
			eFlag=true;
			int index=commandList.indexOf("-e");
			stopList=commandList.get(index+1);
			commandList.remove(index);  //删除  -e
			commandList.remove(index);  //删除   stoplist.txt
		}
		if(commandList.contains("-o")){
			oFlag=true;
		   int index=commandList.indexOf("-o");
		   output=commandList.get(index+1);
		   commandList.remove(index);
		   commandList.remove(index);
		}
		
		
		if(commandList.size()==0){
			System.err.println("errer");
			System.exit(0);
		}
		
		if( batchFlag )
			 file_name=commandList.get(commandList.size()-1); //如果不是批量处理就获取文件名
		if(sFlag && batchFlag){     //如果要进行批量处理
			batchFlag=false;
			batchProcessing(file_name, "", commandList);
		}
	
		
		
		
		else{
			
				if(commandList.contains("-c")){   //统计字符并写到result.txt
					cFlag=true;
					countCharacter(file_name);
				}
				if(commandList.contains("-w")){    //统计单词数
					wFlag=true;
					//System.out.println("wwwwww");
					countWord(file_name);
				}
				
				if(eFlag){                      //忽略停用表统计单词
					countWordWithS(file_name, stopList);
				}
				if(commandList.contains("-l")){    //统计行数
					lFlag=true;
					countLine(file_name);
				}
				if(commandList.contains("-a")){    //行分三类
					aFlag=true;
					differentLine(file_name);
					putLine(resultFile);
				}
				
				
				if(oFlag){            //如果指定了输出文件
					if(cFlag)
						writeC(file_name, output);
					if(wFlag || eFlag)
						writeW(file_name, output);
					if(lFlag)
						writeL(file_name, output);
					if(aFlag)
						putLine(output);
					//writeFile(file_name, output);
				}
		}
	}
}