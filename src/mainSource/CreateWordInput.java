package mainSource;

import java.util.*;

import javax.management.loading.PrivateClassLoader;

import java.io.*;

public class CreateWordInput {
	private Collection <String> input = new Vector<>();	
	
	public CreateWordInput() {		
		setRandomInput(); //Put Words that are used in java to 'input' Collection		
		
		//write all the objects in 'input' to text file
		try {
			FileOutputStream outputStream = new FileOutputStream("Word Input.txt",false);
			PrintWriter writer = new PrintWriter(outputStream);
			for(String inputString : input) {
				writer.println(inputString);
			}
			writer.close();
			outputStream.close();
		} 
		catch (FileNotFoundException e) {		
			e.printStackTrace();
		}		
		catch(IOException e) {
			e.printStackTrace();
		}
	}	
	
	//"setRandomInput" : inputs all the words that will be used
	public void setRandomInput() {
		input.add("int");
		input.add("double");
		input.add("float");
		input.add("String");
		input.add("class");
		input.add("public");
		input.add("private");
		input.add("static");
		input.add("extends");
		input.add("implements");
		input.add("main");
		input.add("import");
		input.add("package");
		input.add("void");
		input.add("Integer");
		input.add("file");
		input.add("throws");
		input.add("throw");
		input.add("boolean");
		input.add("Exception");
		input.add("try");
		input.add("catch");
		input.add("Override");
		input.add("System");
		input.add("out");
		input.add("println");
		input.add("print");
		input.add("printf");
		input.add("format");
		input.add("nextInt");
		input.add("nextDouble");
		input.add("nextFloat");
		input.add("nextLine");
		input.add("char");
		input.add("switch");
		input.add("for");
		input.add("while");
		input.add("short");
		input.add("byte");
		input.add("long");
		input.add("final");
		input.add("Random");
		input.add("else if");
		input.add("break");
		input.add("new");
		input.add("this");
		input.add("set");
		input.add("get");
		input.add("Collection");
		input.add("Vector");
		input.add("ArrayList");
		input.add("List");
		input.add("equals");
		input.add("protected");
		input.add("super");
		input.add("return");
		input.add("toString");
		input.add("abstract");
		input.add("assert");
		input.add("Runnable");
		input.add("Thread");
		input.add("start");
		input.add("dispose");
		input.add("sleep");
		input.add("run");
		input.add("synchronized");
		input.add("done");
		input.add("doInBackground");
		input.add("publish");
		input.add("process");
		input.add("Scanner");
		input.add("FileInputStream");
		input.add("FileOutputStream");
		input.add("FileWriter");
		input.add("FileReader");
		input.add("close");
		input.add("null");
		input.add("Serializable");
		input.add("Double");
		input.add("LinkedList");
		input.add("Iterator");
		input.add("hasNext");
		input.add("PriorityQueue");
		input.add("Set");
	    input.add("InetAddress");
		input.add("Socket");
		input.add("accept");
		input.add("true");
		input.add("false");	
	}
	
	//"getRandomInput" : returns random String in the 'input' Vector
	public String getRandomInput() {
		Random randomGenerator = new Random();
		int randomIndex = randomGenerator.nextInt(input.size());
		int currentIndex = 0;
		for(String str : input) {
			if(currentIndex == randomIndex) {
				return str;
			}
			currentIndex++;
		}
		return null;
	}
}
