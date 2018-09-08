package com.mahendracandi.app;
import com.mahendracandi.app.Burung;

public class Murai extends Burung{
	
	
	public static void main(String[] args){
		Burung b=new Burung();
		b.setMakan("makan tahi");
		System.out.println(b.getMakan());
		System.out.println("oke");
	}
}
