package test;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book
{
	private SimpleStringProperty booka;
	private SimpleStringProperty bookb;
	private SimpleStringProperty bookc;
	private SimpleIntegerProperty bookd;
	private SimpleIntegerProperty booke;
	
	public Book(String booka, String bookb, String bookc, int bookd, int booke) {
		this.booka = new SimpleStringProperty(booka);
		this.bookb = new SimpleStringProperty(bookb);
		this.bookc = new SimpleStringProperty(bookc);
		this.bookd = new SimpleIntegerProperty(bookd);
		this.booke = new SimpleIntegerProperty(booke);
	}
	
	//booka
	public void setBooka(String booka) {
		this.booka.set(booka);
	}
	public String getBooka() {
		return this.booka.get();
	}
	public SimpleStringProperty bookaProperty()
	{
		return this.booka;
	}
	
	//bookb
	public void setBookb(String bookb) {
		this.bookb.set(bookb);
	}
	public String getBookb() {
		return this.bookb.get();
	}
	public SimpleStringProperty bookbProperty()
	{
		return this.bookb;
	}
	
	//bookc
	public void setBookc(String bookc) {
		this.bookc.set(bookc);
	}
	public String getBookc() {
		return this.bookc.get();
	}
	public SimpleStringProperty bookcProperty()
	{
		return this.bookc;
	}
	
	//bookd
	public void setBookd(int bookd)
	{
		this.bookd.set(bookd);
	}

	public int getBookd()
	{
		return this.bookd.get();
	}

	public SimpleIntegerProperty bookdProperty()
	{
		return this.bookd;
	}
	
	//booke
	public void setBooke(int booke)
	{
		this.booke.set(booke);
	}

	public int getBooke()
	{
		return this.booke.get();
	}

	public SimpleIntegerProperty bookeProperty()
	{
		return this.booke;
	}
}
