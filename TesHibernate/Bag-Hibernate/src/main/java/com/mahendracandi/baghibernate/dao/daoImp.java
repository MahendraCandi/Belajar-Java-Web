package com.mahendracandi.baghibernate.dao;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;
import java.util.List;

import com.mahendracandi.baghibernate.util.HibernateUtil;
import com.mahendracandi.baghibernate.dao.dao;
import com.mahendracandi.baghibernate.model.Karyawan;
import com.mahendracandi.baghibernate.model.Sertifikat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;

public class daoImp implements dao{
	
	public boolean addKaryawan(Karyawan karyawan){
		Session session=HibernateUtil.getSessionFactory().openSession();
		if(karyawanExist(karyawan)) return false;
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			session.save(karyawan);
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

	public boolean karyawanExist(Karyawan karyawan){
		Session session=HibernateUtil.getSessionFactory().openSession();
		boolean result=false;
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			Query q=session.createQuery("from Karyawan where idkaryawan = '"+karyawan.getIdKaryawan()+"'");
			Karyawan k=(Karyawan) q.uniqueResult();
			tx.commit();
			if(k != null) result=true;
		}catch(Exception ex){
			if(tx != null){
				tx.rollback();
			}
			ex.printStackTrace();
		}finally{
			session.close();
		}
		return result;
	}

	public void deleteKaryawan(Karyawan karyawan){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx=session.beginTransaction();
			session.delete(karyawan);
			tx.commit();
		}catch(Exception ex){
			if(tx != null){
				tx.rollback();
			}
			ex.printStackTrace();
		}finally{
			//session.flush();
			session.close();
		}
	}

	public void updateKaryawan(Karyawan karyawan){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			session.update(karyawan);
			tx.commit();
		}catch(Exception ex){
			if(tx != null){
				tx.rollback();
			}
			ex.printStackTrace();
		}finally{
			session.close();
		}
	}

	public List<Karyawan> showKaryawan(){
		List<Karyawan> listKaryawan=new ArrayList();
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			Query q=session.createQuery("from Karyawan");
			listKaryawan=q.list();
            tx.commit();
		}catch(Exception ex){
			if(tx != null){
				tx.rollback();
			}
			ex.printStackTrace();
		}finally{
			session.close();
		}
		return listKaryawan;
	}

	public List<Karyawan> showSertifikat(){
		Session session=HibernateUtil.getSessionFactory().openSession();
                List<Karyawan> list;
                List<Karyawan> hasil=new ArrayList();
                Collection<Karyawan> kar;
                Karyawan karyawan=new Karyawan();
                try{
//                        list = session.createQuery("select s from Sertifikat as s left join fetch k.").list();
//                        Iterator itr=list.iterator();
//                        while(itr.hasNext()){
//                            all=(Karyawan) itr.next();
//                            Hibernate.initialize(all.getSertifikat());
//                        }
                        //Query q=session.createQuery("select k.idkaryawan from Karyawan k");
                        
//                        all=(Karyawan) session.get(Karyawan.class, id);
                        session.beginTransaction();
                        Query q=session.createQuery("select k.idKaryawan from Karyawan k");
                        list=q.list();
                        for(int i=0; i <= list.size(); i++){
                            String x=list.get(i).getIdKaryawan();
                            karyawan=session.get(Karyawan.class, x);
                            Hibernate.initialize(karyawan.getSertifikat());
                            hasil.add(karyawan);
                        }
                        
                        
//                        for(Karyawan k : kar){
//                            list.add(k);
//                        }
		}finally{
                    session.close();
                }
                return hasil;
	}

	public Karyawan getKaryawan(String idKaryawan){
		Karyawan karyawan=null;
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			Query q=session.createQuery("from KARYAWAN where idkaryawan = :id");
			q.setString("id", idKaryawan);
			karyawan = (Karyawan) q.uniqueResult();
		}catch(Exception ex){
			if(tx != null){
				tx.rollback();
			}
			ex.printStackTrace();
		}finally{
			session.close();
		}
		return karyawan;
	}
}