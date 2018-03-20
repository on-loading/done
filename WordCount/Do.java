package homework;

import java.util.ArrayList;

public class Do {
	public static void main(String[] args ){
		//String args1="-l -w -c file.txt  -e stopList.txt -o put.txt";
		//String[] args2=args1.split("\\s+");
		ArrayList<String> commandList=new ArrayList<String>();
		for(String s:args)
			commandList.add(s);
		Analysis analysis=new Analysis();
	    analysis.doWork(commandList);

	}
	
}