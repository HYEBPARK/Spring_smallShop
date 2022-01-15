package com.example.smallshop.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class ItemForm {
    private String item_name;
    private int item_price;
}
