package domain;

public class Estudante {

    private Integer id;
    private String name;
    private String year;

    public Estudante(Integer id, String name, String year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }
}
