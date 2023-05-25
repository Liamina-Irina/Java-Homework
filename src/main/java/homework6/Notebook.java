package homework6;

import java.util.Objects;
public class Notebook {
    String brand;
    String model;
    double diagonal;
    int rAM;
    int sSD;
    String operationSystem;
    String colour;
    int price;

    public Notebook(String brand, String model, double diagonal, int rAM, int hDDCapacity,
                    String operationSystem, String colour, int price) {
        this.brand = brand;
        this.model = model;
        this.diagonal = diagonal;
        this.rAM = rAM;
        this.sSD = hDDCapacity;
        this.operationSystem = operationSystem;
        this.colour = colour;
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n").append(brand).append(", ").append(model).append(", ").append(diagonal).append("\"").
                append(", ").append("RAM: ").append(rAM).append(" ГБ").append(", ").append("SSD: ").append(sSD).append(" ГБ").
                append(", ").append("ОС: ").append(operationSystem).append(", ").append("цвет: ").append(colour).append(", ").
                append("цена: ").append(price).append(" руб.");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, diagonal, rAM, sSD, operationSystem,
                colour, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notebook notebook = (Notebook) o;
        return rAM == notebook.rAM && sSD == notebook.sSD && price == notebook.price
                && Double.compare(notebook.diagonal, diagonal) == 0 && brand.equals(notebook.brand)
                && model.equals(notebook.model) && operationSystem.equals(notebook.operationSystem)
                && colour.equals(notebook.colour);

    }
}
