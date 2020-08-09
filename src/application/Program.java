package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Source folder path: ");
		String strFolderPath = sc.nextLine();
		File folder = new File(strFolderPath);
		
		System.out.print("New prefix name you want for your file: ");
		String strPrefixFileName = sc.nextLine();
		
		System.out.print("Exit file type: ");
		String strFileType = sc.nextLine();
		
		sc.close();
		
		File[] listOfFiles = folder.listFiles();
		
		int i = 0;
		for (File file : listOfFiles) { 
			i++;
			
			File newName = new File (folder.getAbsolutePath() + "/" + strPrefixFileName + i + "." + strFileType);
			if (newName.exists()) {
				throw new java.io.IOException("The file" + newName.getName() + " exists");
			}
			file.renameTo(newName);
		}
		System.out.println("Renaming completed");
	}
}
