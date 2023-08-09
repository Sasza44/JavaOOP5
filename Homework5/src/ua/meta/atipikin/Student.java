package ua.meta.atipikin;

public class Student extends Human {
	private int id;
	private String groupName;
	
	public Student() {}
	public Student(String name, String lastName, Gender gender, int id, String groupName) {
		super(name, lastName, gender);
		this.id = id;
		this.groupName = groupName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", groupName=" + groupName + ", " + super.toString();
	}
	
	public String toCSVString() {
		return "Last name = " + this.getLastName() + ", Name = " + this.getName() + ", ID = " + this.getId();
	}
	
	public Student fromCSVString(String str) {
		Student st = new Student();
		int i2 = str.indexOf(", Name = ", 0);
		int i3 = str.indexOf(", ID = ", 0);
		st.setLastName(str.substring(12, i2));
		st.setName(str.substring(i2 + 9, i3));
		st.setId(Integer.parseInt(str.substring(i3 + 7, str.length())));
		return st;
	}
}