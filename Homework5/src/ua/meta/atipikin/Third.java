package ua.meta.atipikin;

import ua.meta.atipikin.Group;
import ua.meta.atipikin.Student;

public class Third {

	public static void main(String[] args) {
		Student tipikin = new Student(); // створення студента
		tipikin.setName("Oleksandr");
		tipikin.setLastName("Tipikin");
		tipikin.setId(7217);
		Student nikolaev = new Student();
		nikolaev.setName("Ivan");
		nikolaev.setLastName("Nikolaev");
		nikolaev.setId(7227);
		Student melnikov = new Student();
		melnikov.setName("Evgen");
		melnikov.setLastName("Melnikov");
		melnikov.setId(7226);
		Student topchiy = new Student();
		topchiy.setName("Yulia");
		topchiy.setLastName("Topchiy");
		topchiy.setId(7216);
		
		Group em72 = new Group(); // створення групи (у якій я навчався в КПІ)
		em72.setGroupName("EM-72");
		
		em72.addStudent(tipikin); // додавання студента в групу
		em72.addStudent(melnikov);
		em72.addStudent(nikolaev);
		em72.addStudent(topchiy);
		em72.sortStudentsByLastName(); // сортування студентів в алфавітному порядку
		//System.out.println(em72);
		em72.groupList(); // запис даних групи студентів в файл
	}
}