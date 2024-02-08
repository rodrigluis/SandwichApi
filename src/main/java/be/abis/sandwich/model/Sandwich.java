package be.abis.sandwich.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "sandwiches")
public class Sandwich {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "BASEPRICE")
    private double basePrice;
    @Column(name = "SALAD_ALLOWED")
    private boolean salad;
    @Column(name = "BREAD_TYPE_ALLOWED")
    private boolean breadType;

    public Sandwich(){}

    public Sandwich(int id, String name, String description, String category, boolean salad, boolean breadType) {
        this.id          = id;
        this.name        = name;
        this.description = description;
        this.category    = category;
        this.salad       = salad;
        this.breadType   = breadType;
    }

    public Sandwich(int id, String name, String description, String category, double basePrice, boolean salad, boolean breadType) {
        this(id,name, description, category, salad, breadType);
        this.basePrice = basePrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public boolean isSaladAllowed() {
        return this.salad;
    }

    public boolean isBreadTypeAllowed() {
        return this.breadType;
    }
}
