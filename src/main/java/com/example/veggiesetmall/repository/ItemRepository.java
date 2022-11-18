package com.example.veggiesetmall.repository;

import com.example.veggiesetmall.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {
        if(item.getId() == null) {  // DB에 저장되기 전에는 id가 부여되지 않으므로 = 새로운 객체라는 의미
            em.persist(item);
        } else {  // 이미 등록된 item임. 의미상 update
            em.merge(item);
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class) // from 절 뒤 Item은 Item Entity를 뜻한다.
                .getResultList();
    }

}
