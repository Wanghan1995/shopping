package com.wang.han;


public class Goods{
	private String name;
	private double price;
	private String made;
	private String date;
	private int amount;
	private String size;

	public Goods(){
	
	}
	public Goods(String name,double price,String made,String date,int amount,String size){
		this.name=name;
		this.price=price;
		this.made=made;
		this.date=date;
		this.amount=amount;
		this.size=size;
	}


	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}

	public void setPrice(double price){
		this.price=price;
	}
	public double getPrice(){
		return this.price;
	}

	public void setMade(String made){
		this.made=made;
	}
	public String getMade(){
		return this.made;
	}

	public void setDate(String date){
		this.date=date;
	}
	public String getDate(){
		return this.date;
	}

	public void setAmount(int amount){
		this.amount=amount;
	}
	public int getAmount(){
		return this.amount;
	}

	public void setSize(String size){
		this.size=size;
	}
	public String getSize(String size){
		return this.size;
	}
	public String toString(){
		return "Goods [name:"+this.name+" price:"+this.price+" made:"+this.made+" date:"+this.date+" size:"+this.size+"]";
	}
}