package com.example.smallshop.service;

import com.example.smallshop.domain.Item;
import com.example.smallshop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Item saveItem(Item item){
        return itemRepository.save(item);
    }

    public List<Item> findAll(){
        List<Item> items = itemRepository.findAll();
        return items;
    }
}
