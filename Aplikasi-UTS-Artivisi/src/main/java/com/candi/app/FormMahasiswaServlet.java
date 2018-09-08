package com.candi.app;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
             
public class FormMahasiswaServlet extends HttpServlet{
	private MahasiswaDAO mahasiswaDao=new MahasiswaDAO();

	public void doGet(HttpServletRequest req, HttpServletResponse res){

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res){
		try{
			Mahasiswa m=new Mahasiswa();
			m.setNpm(req.getParameter("npm")); //getParameter harus sesuai dengan yang dipasang di html
			m.setNama(req.getParameter("nama"));
			m.setTempatLahir(req.getParameter("tempat_lahir"));

			String tgl=req.getParameter("tanggal_lahir");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			m.setTanggalLahir(sdf.parse(tgl));

			m.setJenisKelamin(JenisKelamin.valueOf(req.getParameter("jenis_kelamin").toUpperCase()));
			m.setAlamat(req.getParameter("alamat"));
	
			mahasiswaDao.simpan(m);

			res.sendRedirect("form.html");
		}catch(Exception err){
			err.printStackTrace();		
		}
	}

}
