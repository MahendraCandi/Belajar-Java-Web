package com.mahendra.candi.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mahendra.candi.persistence.HibernateUtil;
import com.mahendra.candi.model.MataKuliah;

public class MataKuliahService{

	public boolean addMataKuliah(MataKuliah mataKuliah){
		Session session = HibernateUtil.getSessionFactory().openSession();
                
                if(matkulEksis(mataKuliah))return false;
                Transaction tx = null;
                try{
                    tx=session.getTransaction();
                    tx.begin();
                    session.saveOrUpdate(mataKuliah);
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
        
        public boolean matkulEksis(MataKuliah mataKuliah){
            Session session=HibernateUtil.getSessionFactory().openSession();
            boolean result=false;
            Transaction tx=null;
            try{
                tx=session.getTransaction();
                tx.begin();                //SELECT * FROM `MATKUL` WHERE MatkulId = 'LGK'
                Query q=session.createQuery("from MATKUL where MatkulId='"+mataKuliah.getMatkulId()+"'");
                System.out.println(mataKuliah.getMatkulId());
                MataKuliah m=(MataKuliah) q.uniqueResult();
                tx.commit();
                if(m != null)result=true;
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