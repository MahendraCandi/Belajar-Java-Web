package com.mahendracandi.hibernatemaven.dao;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;
import java.util.List;
import java.util.ArrayList;

import com.mahendracandi.hibernatemaven.model.*;
import com.mahendracandi.hibernatemaven.util.HibernateUtil;

public class DAO{
    public void tambahBuku(Pengarang pengarang, Penerbit penerbit, Buku buku){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            session.save(penerbit);
            session.save(pengarang);
            session.save(buku);
            tx.commit();
        }catch(Exception ex){
            if(tx!=null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
    }
}