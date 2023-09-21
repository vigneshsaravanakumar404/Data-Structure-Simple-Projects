public record Person(String name, int age, double hourlyWage) {

    public String toString() {
        return "Name: " + name + "\t Age: " + age + "\t Hourly Wage: " + hourlyWage;
    }
}
