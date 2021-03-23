
public class App2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread r1 = new Thread(new Runner2());
		r1.start();
		
		Thread r2 = new Thread(new Runner2());
		r2.start();
	}

}

class Runner2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println("Hello" + i);
		}
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}