public class Student {

    String name;
    int lavaBaths;

    public Student(String name) {
        this.name = name;
        this.lavaBaths = 0;
    }

    public String getName() {
        return name;
    }

    public int getLavaBaths() {
        return lavaBaths;
    }

    public void lavaBaths() {
        lavaBaths++;
    }
}