package com.mahendracandi.formlogin.dao;

import java.io.Serializable;
import com.mahendracandi.formlogin.util.HibernateUtil;
import com.mahendracandi.formlogin.model.Admin;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdminDAO implements Serializable{
    public void tambahAdmin(Admin admin){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            session.save(admin);
            tx.commit();
        }catch(Exception ex){
            if(tx != null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
    }
    
    public List<Admin> dataAdmin(){
        List<Admin> list=new ArrayList();
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            Query q=session.createQuery("FROM Admin");
            list = q.list();
            tx.commit();
        }catch(Exception ex){
            if(tx!=null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
        return list;
    }
    
    public List<Admin> loginAdmin(String user, String pass){
        List<Admin> list=new ArrayList<>();
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            Query q=session.createQuery("SELECT a.id, a.username, a.password, a.email, a.regdate FROM Admin a WHERE (a.username = :user OR a.email = :user) AND a.password = :pass");
            q.setParameter("user", user);
            q.setParameter("pass", pass);
            list = (List<Admin>) q.list();
            tx.commit();
        }catch(Exception ex){
            if(tx!=null){
                tx.rollback();
            }
        }finally{
            session.close();
        }
        return list;
    }
}