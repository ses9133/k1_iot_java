package org.example.chapter10.practice02.repository;

import org.example.chapter10.practice02.entity.Item;

import java.util.HashSet;
import java.util.Set;

public class InMemoryItemRepository implements ItemRepository {
    private Set<Item> items = new HashSet<Item>();

    @Override
    public Set<Item> findAll() {
        return new HashSet<>(items);    // 방어적 복사
    }

    @Override
    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public Item findById(String itemId) {
        for(Item item : items) {
            if(item.getId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void removeItem(String itemId) {
        Item target = null;
        for(Item item : items) {
            if (item.getId().equals(itemId)) {
                target = item;
                break;
            }
        }
        if(target != null) {
            items.remove(target);
        }
     }
}
