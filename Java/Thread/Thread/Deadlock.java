package Thread;

public class Deadlock implements Runnable{
	Object goods = new Object();
	Object money = new Object();
	public Deadlock(Object goods, Object money) {
		super();
		this.goods = goods;
		this.money = money;
	}
	@Override
	public void run() {
		while(true)
			test(goods,money);		
	}

	void test(Object goods, Object money){
		synchronized(goods){
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("货物已交付，等待收款");
			synchronized(money){				
				System.out.println("收款完毕");
			}
		}
	}
	public static void main(String[] args){
		Object goods = new Object();
		Object money = new Object();
		Deadlock dl = new Deadlock(goods, money);
		Auxilary aux = new Auxilary(goods, money);
		Thread proxy1 = new Thread(dl);
		Thread proxy2 = new Thread(aux);
		proxy1.start();
		proxy2.start();
	}
}
class Auxilary extends Deadlock{
	Object goods = new Object();
	Object money = new Object();
	public Auxilary(Object goods, Object money) {
		super(goods, money);
	}
	@Override
	public void run() {
		while(true)
			test(goods,money);		
	}

	void test(Object goods, Object money){
		synchronized(money){
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("已付款，等待收货");
			synchronized(goods){				
				System.out.println("收货成功");
			}
		}
	}
	
}
