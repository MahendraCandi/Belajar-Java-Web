package com.mahendracandi.baghibernate.dao;

import com.mahendracandi.baghibernate.model.Karyawan;
import java.util.List;

public interface dao {
	public boolean addKaryawan(Karyawan karyawan);
	public boolean karyawanExist(Karyawan karyawan);
	public void deleteKaryawan(Karyawan karyawan);
	public void updateKaryawan(Karyawan karyawan);
	public List<Karyawan> showKaryawan();
	public Karyawan getKaryawan(String idKaryawan);
}