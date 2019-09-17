package csDataStruct;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean readfile(String filename, ArrayList<String> words){
		if(filename == null || words == null){
			System.out.println("filename is null or words is null.");
			return false;
		}
		
		Scanner scanner;
		try{
			File file = new File(filename);
			if(file.exists()){
				FileInputStream fis = new FileInputStream(file);
				scanner = new Scanner(new BufferedInputStream(fis), "utf-8");
				scanner.useLocale(Locale.ENGLISH);
			}else{
				System.out.println(filename + " don't exists.");
				return false;
			}
			
			if(scanner.hasNextLine()){
				String contents = scanner.useDelimiter("\\A").next();
				int start = firstCharacterIndex(contents, 0);
				for(int i=start+1;i<contents.length();){
					if(!Character.isLetter(contents.charAt(i))){
						String word = contents.substring(start, i).toLowerCase();
						words.add(word);
						start = firstCharacterIndex(contents, i);
						i = start + 1;
					}else{
						i++;
					}
				}
			}
			scanner.close();
			return true;
		}catch(IOException ioe){
			System.out.println(ioe.toString());
			System.out.println("cannot open file:" +filename);
			return false;
		}
		
	}
	
	public static int firstCharacterIndex(String s, int start){
		for(int i=start;i<s.length();i++){
			if(Character.isLetter(s.charAt(i))){
				return i;
			}
		}
		return s.length();
	}

}
