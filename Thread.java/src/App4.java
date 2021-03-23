
public class App4 {
	public static void main(String[] args) {
		Thread r1 = new Thread() {

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

		};
		r1.start();
	}

}
