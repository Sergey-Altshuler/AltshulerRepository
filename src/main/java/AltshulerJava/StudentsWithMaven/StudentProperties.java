package AltshulerJava.StudentsWithMaven;

public abstract class StudentProperties {

    static final double DEFAULT_TIME=66;
    private double time;
    private double talent;

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getTalent() {
        return talent;
    }

    public void setTalent(double talent) {
        this.talent = talent;
    }

    abstract void displayProperties();
}
