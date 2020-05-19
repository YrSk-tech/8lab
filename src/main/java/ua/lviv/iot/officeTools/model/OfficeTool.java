package ua.lviv.iot.officeTools.model;

import javax.persistence.*;

@Entity
public class OfficeTool {
    @Column(name = "producer")
    private String producer;

    private double priceInUAH;
    @Enumerated(EnumType.STRING)
    private Brand brand;
    @Enumerated(EnumType.STRING)
    private Colour colour;
    private int weightInGrams;
    private int warrantyInDays;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer officeToolId;

    public static Brand nullBrand = null;
    public static Colour nullColour = null;

    public String headers = "producer, priceInUAH, brand, colour, weightInGrams, warrantyInDays";

    public OfficeTool(String producer, double priceInUAH, int weightInGrams, int warrantyInDays) {
        this(null, 0, Brand.AXENT, Colour.RED, 0, 0);
    }

    public OfficeTool() {
        this(null, 0, Brand.AXENT, Colour.RED, 0, 0);
    }

    public OfficeTool(String producer, double priceInUAH, Brand brand, Colour colour, int weightInGrams,
            int warrantyInDays) {
        super();
        this.producer = producer;
        this.priceInUAH = priceInUAH;
        this.brand = brand;
        this.colour = colour;
        this.weightInGrams = weightInGrams;
        this.warrantyInDays = warrantyInDays;
    }

    public Integer getId() {
        return officeToolId;
    }

    public void setId(Integer id) {
        this.officeToolId = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getPriceInUAH() {
        return priceInUAH;
    }

    public void setPriceInUAH(double priceInUAH) {
        this.priceInUAH = priceInUAH;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public int getWeightInGrams() {
        return weightInGrams;
    }

    public void setWeightInGrams(int weightInGrams) {
        this.weightInGrams = weightInGrams;
    }

    public int getWarrantyInDays() {
        return warrantyInDays;
    }

    public void setWarrantyInDays(int warrantyInDays) {
        this.warrantyInDays = warrantyInDays;
    }
}
