package com.metacoding.storev1.store;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class StoreRepository {
    
    private EntityManager em;

    public StoreRepository(EntityManager em){
        this.em = em;
    }
    
    public void save(String name, int stock, int price){
        Query query = em.createNativeQuery("insert into store_tb(name, stock, price) values(?,?,?)");
        query.setParameter(1, name);
        query.setParameter(2, stock);
        query.setParameter(3, price);
        query.executeUpdate();
    }

    // model = List<Store>
    public List<Store> findAll() {
        // 조건 : 오브젝트 매핑은 @Entity가 붙어있어야지만 가능하다. (디폴트 생성자를 호출)
        // reflection을 통한 setter 호출
        Query query = em.createNativeQuery("select * from store_tb order by id desc", Store.class);
        return query.getResultList();
    }

    public Store findById(int id){
        Query query = em.createNativeQuery("select * from store_tb where id = ?" , Store.class);
        query.setParameter(1, id);
        try {
            return (Store) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public void deleteById(int id){
        Query query = em.createNativeQuery("delete from store_tb where id = ?");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public void updateById(int id, String name, int stock, int price) {
        Query query = em.createNativeQuery("update store_tb set name = ?, stock = ?, price = ? where id = ?");
        query.setParameter(1, name);
        query.setParameter(2, stock);
        query.setParameter(3, price);
        query.setParameter(4, id);
        query.executeUpdate();
    }
}
