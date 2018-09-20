package com.example.unittesting.unittesting.repository;

import com.example.unittesting.unittesting.Utils.HibernateUtil;
import com.example.unittesting.unittesting.model.Item;
import org.hibernate.type.descriptor.sql.JdbcTypeFamilyInformation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ItemRepositoryImpl{


    @Transactional
    public Item addElement(Item item) {
        HibernateUtil.initManager();
        HibernateUtil.getEntityManager().clear();
        HibernateUtil.getEntityManager().getTransaction().begin();
        HibernateUtil.getEntityManager().persist(item);
        HibernateUtil.getEntityManager().getTransaction().commit();
        HibernateUtil.shutdown();
        return item;
    }

    @Transactional
    public List<Item> findAllItems() {
        // TODO Auto-generated method stub
        HibernateUtil.initManager();
        HibernateUtil.getEntityManager().clear();
        Query query = HibernateUtil.getEntityManager().createQuery("SELECT item FROM Item item ", Item.class);
        List<Item> result = query.getResultList();
        HibernateUtil.shutdown();
        return result;
    }
}
