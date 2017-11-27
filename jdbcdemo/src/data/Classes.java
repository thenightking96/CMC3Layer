package data;

public class Classes {
	private String classId;
	private String className;
	private String note;

	public Classes() {

	}

	public Classes(String classId, String className, String note) {
		this.classId = classId;
		this.className = className;
		this.note = note;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
