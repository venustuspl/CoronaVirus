package pl.venustus.CoronaVirus;

public class CountryDto {
    private String name;
    private Double count;

    public CountryDto() {
    }

    public CountryDto(String name, Double count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCount() {
        return count;
    }

    public void setCount(Double count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CountryDto{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}




