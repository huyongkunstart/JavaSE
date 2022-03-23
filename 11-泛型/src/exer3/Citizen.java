package exer3;

/**
 * @author hu
 * @create 2022-01-22 22:47
 */
public class Citizen {
    private String name;

    public Citizen() {
    }

    public Citizen(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "name='" + name + '\'' +
                '}';
    }
}
