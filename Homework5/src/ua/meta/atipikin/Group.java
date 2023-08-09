package ua.meta.atipikin;

import java.util.Arrays;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;

public class Group {
	private String groupName;
	private Student[] students = new Student[11]; // програма не дозволить додати більше 10 студентів у групу. Якщо група заповнена, а при запуску пошуку студент не знайдений,
												  // щоб виводило null, а не останнього студента в групі
	public Group() {}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Student[] getStudents() {
		return students;
	}
	public void setStudents(Student[] students) {
		this.students = students;
	}
//	@Override
//	public String toString() {
//		return "Group [groupName=" + groupName + ", students=" + Arrays.toString(students) + "]";
//	}
	public String toString() {
		int i = 0;
		while(students[i] != null) { // створення нового масиву з прізвищами студентів
			i += 1;
		}
		String[] arrLastNames = new String[i];
		for(int j = 0; j < arrLastNames.length; j++) {
			arrLastNames[j] = students[j].getLastName();
		}
		return Arrays.toString(arrLastNames);
	}
	
	public void groupList() { // запис даних групи студентів в файл
		try(PrintWriter list = new PrintWriter("list.txt")) {
			int i = 0;
			while(students[i] != null) { // створення нового масиву з прізвищами студентів
				i += 1;
			}
			String[] st = new String[i];
			for(int j = 0; j < st.length; j++) {
				st[j] = students[j].getLastName() + " " + students[j].getName() + " " + students[j].getId();
				list.println(st[j]);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error file write");
		}	
	}
	
	
	public void addStudent(Student student) { // додавання студента в групу
		boolean b = false; // біт перевірки, чи такий студент доданий у групу
		int i = 0;
		while(students[i] != null) {
			if(students[i] == student) {
				System.out.println("This student already exists in this group.");
				return;
			}
			i += 1;
			if(i >= students.length - 1) {
				System.out.println("The group is full");
			}
		}
		students[i] = student;
		student.setGroupName(this.groupName);
		//System.out.println("Student " + student.getLastName() + " is added to this group.");
	}
	
	
	public Student searchStudentByLastName(String lastName) { // пошук студента в групі
		boolean b = false; // біт, який показує, чи такий студент знайдений
		int i = 0;
		while(students[i] != null) {
			if (students[i].getLastName().equals(lastName)) {
				b = true;
				return students[i];
			}
			i += 1;
		}
		System.out.println("This student isn't found");
		return students[students.length - 1]; // останній елемент масиву (щоб не було помилки компіляції)
	}
	
	
	public boolean removeStudentByID(int id) { // видалення студента за номером заліковки
		boolean b = false; // біт, який показує, чи такий студент знайдений
		int i = 0;
		int j = 0; // індекс видаленого (мабуть відрахованого) студента
		while(students[i] != null) {
			if (students[i].getId() == id) {
				b = true;
				j = i;
			}
			i += 1;
		}
		if(b = true) {
			students[j] = students[i - 1];
			students[i - 1] = null; // коли видаляємо студента всередині списку, останнього переставляємо на місце видаленого
		}
		return b;
	}
	
	public void sortStudentsByLastName() {  // сортування студентів по прізвищу в алфавітному порядку
		int i = 0;
		while(students[i] != null) { // створення нового масиву з прізвищами студентів
			i += 1;
		}
		String[] arrLastNames = new String[i];
		for(int j = 0; j < arrLastNames.length; j++) {
			arrLastNames[j] = students[j].getLastName();
		}
		Arrays.sort(arrLastNames);
		for(int j = 0; j < arrLastNames.length; j++) {
			for(int k = j; k < arrLastNames.length; k++) {
				if(arrLastNames[j] == students[k].getLastName()) {
					Student x = students[k];
					students[k] = students[j];
					students[j] = x;
				}
			}
		}
	}
}