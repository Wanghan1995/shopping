package com.wang.han;

import java.util.Scanner;

public class Shopping{
	private Goods[] goods=new Goods[5];
	private int index;

	public Goods[] find(){
		Goods[] demo=new Goods[index];
		System.arraycopy(goods,0,demo,0,index);
		return demo;
	}

	public void save(Goods good){
		if (index>=goods.length){
			Goods[] demo=new Goods[goods.length+5];
			System.arraycopy(goods,0,demo,0,index);
			goods=demo;
		}
		goods[index++]=good;
		
	}
	public Goods findByName(String name,String size){
		int num=getindexByName(name,size);
		return num==-1?null:goods[num];
	}
	public int findAmount(String name,String size){
		int num=getindexByName(name,size);
		return num==-1?-1:goods[num].getAmount();
	}

	public void deleteByName(String name,String size){
		int num=getindexByName(name,size);
		for(int i=num;i<index-1;i++){
			goods[i]=goods[i+1];
		}
		goods[--index]=null;
	}
	
	public void update(Goods good){
		for (int i=0;i<index ;i++ ){
			if(goods[i].getName().equals(good.getName())){
				if(goods[i].getSize().equals(good.getSize())){
					goods[i].setPrice(good.getPrice());
					goods[i].setMade(good.getMade());
					goods[i].setDate(good.getDate());
					goods[i].setAmount(good.getAmount());
		
				}
			}
		}	
	}

	public Goods Buy(String name,String size){
		int num=getindexByName(name,size);
		return goods[num];
	
	}
	public int getindexByName(String name,String size){
		int num=-1;
		for (int i=0;i<index ;i++ ){
			if(goods[i].getName().equals(name)){
				if(goods[i].getSize().equals(size)){
					num=i;
					break;
				}
			}
		}
		return num;
	}
	public int getindexByName(String name){
		int num=-1;
		for(int i=0;i<index;i++){
			if(goods[i].getName().equals(name)){
				num=i;
				break;
			}
		}
		return num;
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
						System.out.println("�������ѯʣ����������Ʒ��name#size��������break������һ��Ŀ¼");
						String inStr=sc.nextLine();
						if(inStr.equals("break")){
							break;
						}
						String[] NS=inStr.split("#");
						String name =NS[0];
						String size =NS[1];
						int num=shop.findAmount(name,size);
						System.out.println(num==-1?"�Բ���δ��ѯ����Ҫ����Ʒ��ʣ������":"��Ҫ��ѯ����Ʒ��ʣ������Ϊ��"+num);
				}					
					break;
				case "4":
					while(true){
						System.out.println("������ɾ����Ʒ�ġ�name#size��������break������һ��Ŀ¼");
						String inStr=sc.nextLine();
						if(inStr.equals("break")){
							break;
						}
						String[] In=inStr.split("#");
						String name =In[0];
						String size =In[1];
						Goods good=shop.findByName(name,size);
						if (good==null){
							System.out.println("�Բ���������ѯ����Ʒ������");
							continue;
						}else{
							System.out.println("��Ҫɾ������Ʒ��ϢΪ"+good+"\nȷ��������Yes\n");
							String op = sc.nextLine();
							if(op.equals("Yes")){
								shop.deleteByName(name,size);
								System.out.println("ɾ���ɹ���");
							}else{
								System.out.println("ɾ��ʧ�ܣ�����");

							}
						}
				}				
					break;
				case "5":
					while(true){
						System.out.println("�����������Ʒ�ġ�name#size��������break������һ��Ŀ¼");
						String inStr=sc.nextLine();
						if(inStr.equals("break")){
							break;
						}
						String[] In=inStr.split("#");
						String name =In[0];
						String size =In[1];
						Goods good=shop.findByName(name,size);
						if(good ==null){
							System.out.println("��Ҫ���µ���Ʒ��Ϣ������");
							break;
						}
						System.out.println("��Ҫ���µ���Ʒ��ϢΪ��"+good);
						System.out.println("��������Ϣ��price#made#date#amount��");
						String str=sc.nextLine();
						String[] goodArr=str.split("#");
						double price=Double.parseDouble(goodArr[0]);
						String made =goodArr[1];
						String date =goodArr[2];
						int amount=Integer.parseInt(goodArr[3]);
						Goods newgood=new Goods(name,price,made,date,amount,size);
						shop.update(newgood);
						System.out.println("�޸ĳɹ�");
						
				}					
					break;
				case "6":
					while(true){
						System.out.println("���빺����Ʒ�ġ�name#size��������break������Ҫһ��Ŀ¼");
						String inStr=sc.nextLine();
						if(inStr.equals("break")){
							break;
						}
						String[] In=inStr.split("#");
						String name =In[0];
						String size =In[1];
						Goods Buy=shop.findByName(name,size);
						if(Buy ==null){
							System.out.println("��Ҫ�������Ʒ��Ϣ������");
							break;
						}
						
						System.out.println("�������ƷΪ"+Buy+"\nȷ��������Yes");
						String op = sc.nextLine();
							if(op.equals("Yes")){
								shop.Buy(name,size);
								System.out.println("����ɹ���");
							}else{
								System.out.println("����ʧ�ܣ�����");
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