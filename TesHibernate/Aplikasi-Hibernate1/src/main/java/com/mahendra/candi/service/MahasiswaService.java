package com.mahendra.candi.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mahendra.candi.persistence.HibernateUtil;
import com.mahendra.candi.model.Mahasiswa;

public class MahasiswaService{

	public boolean addMahasiswa(Mahasiswa mahasiswa){
		Session session = HibernateUtil.getSessionFactory().openSession();

		if(mahasiswaEksis(mahasiswa)) return false;

		Transaction tx = null;
		try{
			tx = session.getTransaction();
			tx.begin();
			session.saveOrUpdate(mahasiswa);
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
        
        public boolean mahasiswaEksis(Mahasiswa mahasiswa){
            Session session=HibernateUtil.getSessionFactory().openSession();
            boolean result = false;
            Transaction tx = null;
            try{
                tx = session.getTransaction();
                tx.begin();
                Query q=session.createQuery("from MAHASISWA where id = '"+mahasiswa.getId()+"' ");
                Mahasiswa m=(Mahasiswa) q.uniqueResult();
                tx.commit();
                if(m != null) result = true;
                
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