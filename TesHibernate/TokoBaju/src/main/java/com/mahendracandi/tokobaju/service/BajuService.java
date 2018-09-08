package com.mahendracandi.tokobaju.service;

import org.hibernate.Query;
import org.hibernate.Transaction;

import com.mahendracandi.tokobaju.model.Baju;
import com.mahendracandi.tokobaju.persistence.NewHibernateUtil;
import org.hibernate.Session;

public class BajuService {
    public boolean addBaju(Baju baju){
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        
        if(bajuEksis(baju)) return false;
        Transaction tx=null;
        try{
            tx=session.getTransaction();
            tx.begin();
            session.saveOrUpdate(baju);
            tx.commit();
        }catch(Exception ex){
            if(tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
        return true;
    }
    
    public boolean bajuEksis(Baju baju){
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        boolean result = false;
        Transaction tx = null;
        try{
            tx=session.getTransaction();
            tx.begin();
            Query q=session.createQuery("from Baju where KodeBaju='"+baju.getKodeBaju()+"'");
            Baju b=(Baju) q.uniqueResult();
            tx.commit();
            if(b != null) result=true;
        }catch(Exception ex){
            if(tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
        return result;
    }
}
