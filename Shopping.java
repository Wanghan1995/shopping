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
						System.out.println("请输入查询剩余数量的商品【name#size】或输入break返回上一级目录");
						String inStr=sc.nextLine();
						if(inStr.equals("break")){
							break;
						}
						String[] NS=inStr.split("#");
						String name =NS[0];
						String size =NS[1];
						int num=shop.findAmount(name,size);
						System.out.println(num==-1?"对不起，未查询到您要的商品的剩余数量":"您要查询的商品的剩余数量为："+num);
				}					
					break;
				case "4":
					while(true){
						System.out.println("请输入删除商品的【name#size】或输入break返回上一级目录");
						String inStr=sc.nextLine();
						if(inStr.equals("break")){
							break;
						}
						String[] In=inStr.split("#");
						String name =In[0];
						String size =In[1];
						Goods good=shop.findByName(name,size);
						if (good==null){
							System.out.println("对不起，您所查询的商品不存在");
							continue;
						}else{
							System.out.println("您要删除的商品信息为"+good+"\n确定请输入Yes\n");
							String op = sc.nextLine();
							if(op.equals("Yes")){
								shop.deleteByName(name,size);
								System.out.println("删除成功！");
							}else{
								System.out.println("删除失败！！！");

							}
						}
				}				
					break;
				case "5":
					while(true){
						System.out.println("请输入更新商品的【name#size】或输入break返回上一级目录");
						String inStr=sc.nextLine();
						if(inStr.equals("break")){
							break;
						}
						String[] In=inStr.split("#");
						String name =In[0];
						String size =In[1];
						Goods good=shop.findByName(name,size);
						if(good ==null){
							System.out.println("您要更新的商品信息不存在");
							break;
						}
						System.out.println("您要更新的商品信息为："+good);
						System.out.println("输入新信息【price#made#date#amount】");
						String str=sc.nextLine();
						String[] goodArr=str.split("#");
						double price=Double.parseDouble(goodArr[0]);
						String made =goodArr[1];
						String date =goodArr[2];
						int amount=Integer.parseInt(goodArr[3]);
						Goods newgood=new Goods(name,price,made,date,amount,size);
						shop.update(newgood);
						System.out.println("修改成功");
						
				}					
					break;
				case "6":
					while(true){
						System.out.println("输入购买商品的【name#size】或输入break返回上要一级目录");
						String inStr=sc.nextLine();
						if(inStr.equals("break")){
							break;
						}
						String[] In=inStr.split("#");
						String name =In[0];
						String size =In[1];
						Goods Buy=shop.findByName(name,size);
						if(Buy ==null){
							System.out.println("您要购买的商品信息不存在");
							break;
						}
						
						System.out.println("购买的商品为"+Buy+"\n确认请输入Yes");
						String op = sc.nextLine();
							if(op.equals("Yes")){
								shop.Buy(name,size);
								System.out.println("购买成功！");
							}else{
								System.out.println("购买失败！！！");
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