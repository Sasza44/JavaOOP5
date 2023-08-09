package ua.meta.atipikin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Second {

	public static void main(String[] args) {
		File f1 = new File("Source/1.txt"); // перший текстовий файл
		File f2 = new File("Source/2.txt"); // другий текстовий файл
		File f5 = new File("5.txt"); // текстовий файл, у якому буде вміст двох попередніх
		try {
			fileCopy(f1, f5);
			fileCopy(f2, f5);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void fileCopy(File in, File out) throws IOException {
		byte[] buffer = new byte[30 * 1024];
		int readByte = 0;
		try (FileInputStream fis = new FileInputStream(in);
				FileOutputStream fos = new FileOutputStream(out, true)) {
			
			readByte = fis.read(buffer);
			fos.write(buffer, 0, readByte);
			//System.out.println(readByte);
			
		} catch(IOException e) {
			throw e;
		}
	}
}