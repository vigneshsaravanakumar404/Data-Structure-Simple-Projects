public class Student implements Comparable<Student> {
	private String firstName;
	private String lastName;
	private String noun;
	private String oneThing;

	public Student(String f, String l, String n, String o) {
		firstName = f;
		lastName = l;
		noun = n;
		oneThing = o;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getNoun() {
		return noun;
	}

	public String getOneThing() {
		return oneThing;
	}

	public String toString() {
		return firstName + " " + lastName;
	}

	public int compareTo(Student other) {
		return this.toString().compareTo(other.toString());
	}

    public void lavaBaths() {
    }

}