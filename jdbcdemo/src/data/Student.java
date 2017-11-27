package data;

public class Student implements Comparable<Student>{
	private int studentId;
	private String fullName;
	private String address;
	private int age;
	public Student(){
		
	}
	public Student(int studentId, String fullName, String address, int age) {
		this.studentId = studentId;
		this.fullName = fullName;
		this.address = address;
		this.age = age;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int compareTo(Student s) {
		if(age == s.age){
			return 0;
		}else if(age >s.age){
			return 1;
		}else return -1;
		
	}

}
