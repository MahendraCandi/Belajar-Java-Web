package com.mahendracandi.lazyload.dao;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;
import java.util.List;
import java.util.ArrayList;

import com.mahendracandi.lazyload.util.HibernateUtil;
import com.mahendracandi.lazyload.model.Department;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;

public class DAO{
    public boolean addDepartmen(Department department){
        Session session=HibernateUtil.getSessionFactory().openSession();
        if(departmentExist(department))return false;
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            session.save(department);
            tx.commit();
        }catch(Exception ex){
            if(tx != null){
                tx.rollback();
            }
            ex.printStackTrace();
        }finally{
            session.close();
        }
        return true;
    }
    
    private boolean departmentExist(Department department){
        Session session=HibernateUtil.getSessionFactory().openSession();
        boolean result=false;
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            Query q=session.createQuery("from Department where id = '"+department.getIdDepartment()+"' ");
            Department dp=(Department) q.uniqueResult();
            tx.commit();
            if(dp!=null) result=true;
        }catch(Exception ex){
            if(tx!=null){
                tx.rollback();
            }
            ex.printStackTrace();
        }finally{
            session.close();
        }
    return result; 
    }
    
    public List<Department> tampilDepartment(){
        List<Department> list=new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            Query q=session.createQuery("from Department");
            list=q.list();
            tx.commit();
        }catch(Exception ex){
            if(tx!=null){
                tx.rollback();
            }
            ex.printStackTrace();
        }finally{
            session.close();
        }
        return list;
    }
    
    public Department tampilSertifikat(int id){
        Department dept=new Department();
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try{
            tx=session.beginTransaction();
            dept = (Department) session.createCriteria(Department.class).add(Restrictions.idEq(id));
            Hibernate.initialize(dept.getStudent());
        }catch(Exception ex){
            if(tx!=null){
                tx.rollback();
            }
            ex.printStackTrace();
        }finally{
            session.close();
        }
        return dept;
    }    
}