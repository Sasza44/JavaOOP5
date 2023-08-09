package ua.meta.atipikin;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Fourth {

	public static void main(String[] args) {
		File file = new File("list.txt");
		String[] list = readingFromFile(file); // зчитування даних з файлу
		for(int i = 0; i < list.length; i++) {
			System.out.println(list[i]); // виведення списку студентів
		}
	}
	
	public static String[] readingFromFile(File file) { // зчитування даних з файлу
		try(Scanner sc = new Scanner(file)) {
			String[] list = new String[10]; // новий список (з запасом)
			int n1 = 0;
			for(;sc.hasNextLine();) { // визначення кількості студентів в групі
				list[n1] = sc.nextLine();
				n1 += 1;
			}
			String[] list1 = new String[n1];
			for(int i = 0; i < list1.length; i++) {
				list1[i] = list[i];
			}
			return list1;
		} catch (IOException e) {
			System.out.println(e);
		}
		String[] a1 = new String[10];
		return a1;
	}
}