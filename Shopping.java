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
		System.out.println("&&&&&&&&&&&�������ϵͳ&&&&&&&&&&&");
		System.out.println("1) ��ѯ��Ʒ������Ϣ");
		System.out.println("2) ������Ʒ��Ϣ");
		System.out.println("3) ��ѯ��Ʒ��ʣ������");
		System.out.println("4) ɾ����Ʒ��Ϣ");
		System.out.println("5) ������Ʒ��Ϣ");
		System.out.println("6) ������Ʒ");
		System.out.println("help ��ȡ���� ");
		System.out.println("exit �˳�ϵͳ��");
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		Shopping shop=new Shopping();
		shop.menu();
		while (true){
			System.out.println("�������Ӧָ��");
			String option=sc.nextLine();
			switch(option){
				case "1":
					System.out.println("��������Ʒ��Ϣ");
					Goods[] goods=shop.find();
					for (Goods good:goods){
						System.out.println(good);
					}
					System.out.println("�ܹ���ѯ��"+shop.index+"����Ʒ��Ϣ");
					break;
				case "2":
					while(true){
						System.out.println(" ��������Ʒ��Ϣ��name#price#made#date#amount#size��������break������һ��Ŀ¼");
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
						System.out.println("����ɹ�");
				}					
					break;
				case "3":
					while(true){
						System.out.println("�������ѯʣ����������Ʒname������break������һ��Ŀ¼");
						String inStr=sc.nextLine();
						if(inStr.equals("break")){
							break;
						}
				}					
					break;
				case "4":
					while(true){
						System.out.println("������ɾ����Ʒ��name������break������һ��Ŀ¼");
						String inStr=sc.nextLine();
						if(inStr.equals("break")){
							break;
						}
				}				
					break;
				case "5":
					while(true){
						System.out.println("�����������Ʒ��name������break������һ��Ŀ¼");
						String inStr=sc.nextLine();
						if(inStr.equals("break")){
							break;
						}
				}					
					break;
				case "6":
					while(true){
						System.out.println("���빺����Ʒ�ġ�name#size��������break������Ҫһ��Ŀ¼");
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
					System.out.println("&&��ӭ�´�ʹ��&&");
					System.exit(0);
					break;
				default:
					System.out.println("������Ϣ���󣡣�������������");
			}
		}
	}
}