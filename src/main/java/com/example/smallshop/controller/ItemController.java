package com.example.smallshop.controller;

import com.example.smallshop.domain.Item;
import com.example.smallshop.domain.ItemForm;
import com.example.smallshop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/item")
    public String createItem(Model model){
        model.addAttribute("itemForm", new ItemForm());
        return "/item/createItemForm";
    }

    @PostMapping("/item")
    public String create(ItemForm itemForm){
        Item item = Item.createItem(itemForm);
        itemService.saveItem(item);
        return "redirect:/";
    }

    @GetMapping("/item/list")
    public String itemList(Model model){
        List<Item> items = itemService.findAll();
        model.addAttribute("items",items);
        return "/item/ItemList";
    }

}
