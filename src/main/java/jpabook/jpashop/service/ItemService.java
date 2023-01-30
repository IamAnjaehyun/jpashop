package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) //저장안됨 롤백됨
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional//얘는 저장되어야함
    public void saveItem(Item item){
        itemRepository.save(item);
    }

    @Transactional
    //변경감지 기능
    public void updateItem(Long itemId, String name,int price, int stockQuantity){
        Item findItem = itemRepository.findOne(itemId);
//        findItem.change(price, name, stockQuantity); //실제로는 이런식으로 변경할 수 있게 해야함
        findItem.setPrice(price);
        findItem.setName(name);
        findItem.setStockQuantity(stockQuantity);
    }

    public List<Item> findItems(){
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId){
        return itemRepository.findOne(itemId);
    }
}
