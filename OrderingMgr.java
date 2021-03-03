package org.jgstest;

import java.util.Scanner;

public class OrderingMgr {
	public static void main(String[] args) {
		
		//订单信息
		int[] sequence = new int[4]; //序号
		String[] name = new String[4];//订餐人姓名
		String[] dishMeg = new String[4]; //菜品信息
		int[] dishNum = new int[4]; //菜品数量
		double[] times = new double[4];//送餐时间
		String[] adresses = new String[4];//送餐地址
		int[] states = new int[4];//订单状态，0表示没送，1表示送了
		double[] sumPrices = new double[4];//订单总金额
		
		//餐品信息
		String[] dishNames = {"红烧带鱼","鱼香肉丝","时令小菜"};
		double[] prices = new double[] {38.0,20,10};
		int[] praiseNums = new int[3];
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("欢迎使用吃货订餐系统");
		System.out.println("请选择服务项目：1：我要订餐；2：查看餐袋；3：签收订单；4：删除订单；5：我要点赞；6：退出系统");
		int choose = scanner.nextInt();
		
		int a =0;
		int b = 0;
		
		
		while (true) {
			//订餐模块

			while (choose==1) {
				
				System.out.println("请输入姓名,送餐时间，送餐地址");
				name[a] = scanner.next();
				times[a] = scanner.nextDouble();
				adresses[a] = scanner.next();
				System.out.println("请选择菜品：红烧带鱼，鱼香肉丝，时令小菜");
				dishMeg[a] = scanner.next();
				System.out.println("请选择菜品数量");
				dishNum[a] = scanner.nextInt();
				for (int i = 0; i < dishNames.length; i++) {
					if (dishMeg[a].equals(dishNames[i])) {
						b=i;					
					}
				}
				sumPrices[a] = prices[b]*dishNum[a];
				states[a] = 0;
				a++;
				System.out.println("请选择服务项目：1：我要订餐；2：查看餐袋；3：签收订单；4：删除订单；5：我要点赞；6：退出系统");
				choose = scanner.nextInt();
				break;
				
				
			}
			//查看餐袋模块
			while (choose==2) {
				
				System.out.print("序号"+"\t");
				System.out.print("订餐人"+"\t");
				System.out.print("餐品名称"+"\t");
				System.out.print("菜品数量"+"\t");
				System.out.print("送餐时间"+"\t");
				System.out.print("送餐地址"+"\t");
				System.out.print("总金额"+"\t");
				System.out.print("订单状态"+"\t");
				System.out.println();
				for (int i = 0; i < name.length; i++) {
					int j = i+1;
					sequence[i] = j;
					System.out.print(sequence[i]+"\t");
					System.out.print(name[i]+"\t");
					System.out.print(dishMeg[i]+"\t");
					System.out.print(dishNum[i]+"\t");
					System.out.print(times[i]+"\t");
					System.out.print(adresses[i]+"\t");
					System.out.print(sumPrices[i]+"\t");
					System.out.print(states[i]);
					System.out.println();
				}
				System.out.println("请选择服务项目：1：我要订餐；2：查看餐袋；3：签收订单；4：删除订单；5：我要点赞；6：退出系统");
				choose = scanner.nextInt();
				break;
				
			}
			//签收订单模块
			while (choose==3) {
				String order;
				System.out.println("请输入你需要签收订单的姓名：");
				order = scanner.next();
				for (int i = 0; i < name.length; i++) {
					if (order.equals(name[i])) {
						states[i] = 1;
					}
				}
				System.out.println("请选择服务项目：1：我要订餐；2：查看餐袋；3：签收订单；4：删除订单；5：我要点赞；6：退出系统");
				choose = scanner.nextInt();
				break;
			}
			//删除订单模块，如果states == 1 即删除订单
			while (choose==4) {
				int c = 0;
				String order;
				System.out.println("请输入你要删除订单的姓名：");
				order = scanner.next();
				
				//寻找输入姓名的数组下标
				for (int i = 0; i < name.length; i++) {
					if (order.equals(name[i])) {
						c = i;
					}
				}
				
				
				
				//删除stares == 1 的元素
				if (states[c]==1) {
					// int 类型数组，序号，菜品数量，states状态
					int tem1 = 0;
					for (int i = c; i < sequence.length; i++) {
						if (i<sequence.length-1) {
							tem1 = sequence[i];
							sequence[i] = sequence[i+1];
							sequence[i+1] = tem1;
						}
						sequence[sequence.length-1] = 0;
					}
					
					for (int i = 0; i < dishNum.length; i++) {
						if (i<dishNum.length-1) {
							tem1 = dishNum[i];
							dishNum[i] = dishNum[i+1];
							dishNum[i+1] = tem1;
						}
						dishNum[dishNum.length-1] = 0;
					}
					
					for (int i = 0; i < states.length; i++) {
						if (i<states.length-1) {
							tem1 = states[i];
							states[i] = states[i+1];
							states[i+1] = tem1;
						}
						states[states.length-1] = 0;
					}
					
					//String类型 名字，菜品信息，送餐地址
					String tem2;
					for (int i = 0; i < name.length; i++) {
						if (i<name.length-1) {
							tem2 = name[i];
							name[i] = name[i+1];
							name[i+1] = tem2;
						}
						name[name.length-1] = null;
					}
					
					for (int i = 0; i < dishMeg.length; i++) {
						if (i<dishMeg.length-1) {
							tem2 = dishMeg[i];
							dishMeg[i] = dishMeg[i+1];
							dishMeg[i+1] = tem2;
						}
						dishMeg[dishMeg.length-1] = null;
					}
					
					for (int i = 0; i < adresses.length; i++) {
						if (i<adresses.length-1) {
							tem2 = adresses[i];
							adresses[i] = adresses[i+1];
							adresses[i+1] = tem2;
						}
						adresses[adresses.length-1] = null;
					}
					
					//double 类型 送餐时间，订单总金额
					double tem3;
					for (int i = 0; i < times.length; i++) {
						if (i<times.length-1) {
							tem3 = times[i];
							times[i] = times[i+1];
							times[i+1] = tem3;
						}
						times[times.length-1] = 0.0;
					}
					
					for (int i = 0; i < sumPrices.length; i++) {
						if (i<sumPrices.length-1) {
							tem3 = sumPrices[i];
							sumPrices[i] = sumPrices[i+1];
							sumPrices[i+1] = tem3;
						}
						sumPrices[sumPrices.length-1] = 0.0;
					}
			
				}
				else {
					System.out.println("此订单还未签收，不可删除。");
				}
				System.out.println("请选择服务项目：1：我要订餐；2：查看餐袋；3：签收订单；4：删除订单；5：我要点赞；6：退出系统");
				choose = scanner.nextInt();
				break;
				
			}
			
			//点赞模块
			while (choose==5) {
				/*
				 * //餐品信息 String[] dishNames = {"红烧带鱼","鱼香肉丝","时令小菜"}; double[] prices = new
				 * double[] {38.0,20,10}; int[] praiseNums = new int[3];
				 */
				//点赞之前
				
				System.out.print("餐品名"+"\t");
				System.out.print("餐品价格"+"\t");
				System.out.print("点赞数"+"\t");
				System.out.println();
				/*
				 * System.out.print("红烧带鱼"+"\t"); System.out.print("鱼香肉丝"+"\t");
				 * System.out.print("时令小菜"+"\t"); System.out.println();
				 */
				for (int i = 0; i < dishNames.length; i++) {
					System.out.print(dishNames[i]+"\t");
					System.out.print(prices[i]+"\t");
					System.out.print(praiseNums[i]+"\t");
					System.out.println();
				}
				System.out.println("请输入你要点赞的菜品：");
				String dish;
				dish = scanner.next();
				for (int i = 0; i < dishNames.length; i++) {
					if (dish.equals(dishNames[i])) {
						praiseNums[i]+=1;
					}
				}
				//点赞之后
				System.out.print("红烧带鱼"+"\t");
				System.out.print("鱼香肉丝"+"\t");
				System.out.print("时令小菜"+"\t");
				System.out.println();
				for (int i = 0; i < dishNames.length; i++) {
					System.out.print(dishNames[i]+"\t");
					System.out.print(prices[i]+"\t");
					System.out.print(praiseNums[i]+"\t");
					System.out.println();
				}
				System.out.println("请选择服务项目：1：我要订餐；2：查看餐袋；3：签收订单；4：删除订单；5：我要点赞；6：退出系统");
				choose = scanner.nextInt();
				break;
				
			}
			if (choose==6) {
				System.out.println("推出系统！");
				break;
			}
			
		}
		
		
	}

}
