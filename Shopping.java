package com.wang.han;

import java.util.Scanner;

public class Shopping{
	private Goods[] goods=new Goods[5];
	private int index;

	public Goods[] find(){
		return null;
	}

	public void save(Goods good){
		if (index>=goods.length){
			Goods[] demo=new Goods[goods.length+5];
			System.arraycopy(goods,0,demo,0,index);
			goods=demo;
		}
		goods[index++]=good;
		
	}

	public String[] findAmount(){
		return null;
	}

	public void deleteByName(){
	
	}
	
	public void update(){
	
	}

	public void buy(){
	
	}

	public void menu(){
		System.out.println("&&&&&&&&&&&购物管理系统&&&&&&&&&&&");
		System.out.println("1) 查询商品基本信息");
		System.out.println("2) 输入商品信息");
		System.out.println("3) 查询商品的剩余数量");
		System.out.println("4) 删除商品信息");
		System.out.println("5) 更新商品信息");
		System.out.println("6) 购买商品");
		System.out.println("help 获取帮助 ");
		System.out.println("exit 退出系统！");
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		Shopping shop=new Shopping();
		shop.menu();
		while (true){
			System.out.println("请输入对应指令");
			String option=sc.nextLine();
			switch(option){
				case "1":
					System.out.println("以下是商品信息");
					Goods[] goods=shop.find();
					for (Goods good:goods){
						System.out.println(good);
					}
					System.out.println("总共查询到"+shop.index+"个商品信息");
					break;
				case "2":
					while(true){
						System.out.println(" 请输入商品信息【name#price#made#date#amount#size】或输入break返回上一级目录");
						String inStr=sc.nextLine();
						if(inStr.equals("break")){
							break;
						}
						String[] commodity=inStr.split("#");
						String name=commodity[0];
						double price=Double.parseDouble(commodity[1]);
						String made = commodity[2];
						String date=commodity[3];
						int amount=Integer.parseInt(commodity[4]);
						String size=commodity[5];
						Goods good=new Goods(name,price,made,date,amount,size);
						shop.save(good);
						System.out.println("保存成功");
				}					
					break;
				case "3":
					while(true){
						System.out.println("请输入查询剩余数量的商品name或输入break返回上一级目录");
						String inStr=sc.nextLine();
						if(inStr.equals("break")){
							break;
						}
				}					
					break;
				case "4":
					while(true){
						System.out.println("请输入删除商品的name或输入break返回上一级目录");
						String inStr=sc.nextLine();
						if(inStr.equals("break")){
							break;
						}
				}				
					break;
				case "5":
					while(true){
						System.out.println("请输入更新商品的name或输入break返回上一级目录");
						String inStr=sc.nextLine();
						if(inStr.equals("break")){
							break;
						}
				}					
					break;
				case "6":
					while(true){
						System.out.println("输入购买商品的【name#size】或输入break返回上要一级目录");
						String inStr=sc.nextLine();
						if(inStr.equals("break")){
							break;
						}
				}					
					break;
				case "help":
					shop.menu();
					break;
				case "exit":
					System.out.println("&&欢迎下次使用&&");
					System.exit(0);
					break;
				default:
					System.out.println("输入信息错误！！！请重新输入");
			}
		}
	}
}