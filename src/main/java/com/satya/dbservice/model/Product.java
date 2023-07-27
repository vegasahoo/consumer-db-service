package com.satya.dbservice.model;

import lombok.Data;

@Data
public class Product {
    private int id;
    private int price;
    private String code;
    private Brand brand;
    private Color color;
    private Category category;
}
