package ua.meta.atipikin;

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class First {

	public static void main(String[] args) {
		File source = new File("Source"); // каталог-джерело
		File[] s1 = source.listFiles(); // масив усіх файлів в каталозі-джерелі
		int l2 = 0; // визначаємо довжину масиву з файлів з розширенням ".docx"
		for(File file: s1) {
			if(file.getName().lastIndexOf(".docx") != -1) {
				l2 += 1;
			}
		}
		File[] s2 = new File[l2]; // масив файлів з розширенням ".docx" в каталозі-джерелі
		l2 = 0;
		for(File file: s1) {
			if(file.getName().lastIndexOf(".docx") != -1) {
				s2[l2] = file;
				l2 += 1;
			}
		}
		File receiver = new File("Receiver"); // каталог-приймач
		File[] s3 = new File[l2]; // масив файлів з розширенням ".docx" в каталозі-приймачі
		for(int i = 0; i < s2.length; i++) {
			s3[i] = new File(receiver.getName() + "/" +s2[i].getName());
		}
		for(int i = 0; i < s2.length; i ++) {
			try {
				fileCopy(s2[i], s3[i]);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
 	}
	
	public static void fileCopy(File in, File out) throws IOException {
		byte[] buffer = new byte[3 * 1024 * 1024];
		int readByte = 0;
		try (FileInputStream fis = new FileInputStream(in);
				FileOutputStream fos = new FileOutputStream(out)) {
			for(;(readByte = fis.read(buffer)) > 0;) {
				fos.write(buffer, 0, readByte);
			}
		} catch(IOException e) {
			throw e;
		}
	}
}