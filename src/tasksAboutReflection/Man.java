package tasksAboutReflection;

public class Man {
    private int age;
    private boolean isMarried;
    private boolean isUnemployed;

    public Man(int age, boolean isMarried, boolean isUnemployed) {
        this.age = age;
        this.isMarried = isMarried;
        this.isUnemployed = isUnemployed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public boolean isUnemployed() {
        return isUnemployed;
    }

    public void setUnemployed(boolean unemployed) {
        isUnemployed = unemployed;
    }
}
