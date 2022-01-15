package com.example.smallshop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_id;

    @Column(name = "ITEM_NAME")
    private String item_name;

    @Column(name = "ITEM_PRICE")
    private int item_price;

    public static Item createItem(ItemForm itemForm){
        Item item = new Item();
        item.setItem_name(itemForm.getItem_name());
        item.setItem_price(itemForm.getItem_price());

        return item;
    }

}
