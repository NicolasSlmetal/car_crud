package com.projeto1.model;

import com.projeto1.exceptions.EmptyFieldException;
import com.projeto1.exceptions.InvalidPortsNumberException;
import com.projeto1.exceptions.InvalidYearException;

public class Car {
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String color;
    private String category;

    private String country;
    private Integer ports;
    private Double price;
    private String engine;

    public Car(){

    }

    public Car(
               String name,
               String brand,
               Integer year,
               String color,
               String category,
               String country,
               Integer ports,
               Double price,
               String engine) {
        setName(name);
        setBrand(brand);
        setYear(year);
        setColor(color);
        setCategory(category);
        setCountry(country);
        setPorts(ports);
        setPrice(price);
        setEngine(engine);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank() || name.isEmpty()) throw new EmptyFieldException("nome");
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand.isBlank() || brand.isEmpty()) throw new EmptyFieldException("marca");
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        if (year < 1930) throw new InvalidYearException(year);
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color.isBlank() || color.isEmpty()) throw new EmptyFieldException("cor");
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (category.isBlank() || category.isEmpty()) throw new EmptyFieldException("categoria");
        this.category = category;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country.isBlank() || country.isEmpty()) throw new EmptyFieldException("país");
        this.country = country;
    }

    public Integer getPorts() {
        return ports;
    }

    public void setPorts(Integer ports) {
        if (ports < 2) throw new InvalidPortsNumberException(ports);
        this.ports = ports;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        if (engine.isBlank() || engine.isEmpty()) throw new EmptyFieldException("motor");
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", category='" + category + '\'' +
                ", country='" + country + '\'' +
                ", ports=" + ports +
                ", price=" + price +
                ", engine='" + engine + '\'' +
                '}';
    }
}
