package JFrame;

import javax.swing.JFrame;

public class JNotePadUI extends JFrame{
	public JNotePadUI() {
		super("新增文字文件");
		setUpUIComponent();
		setUpEventListenr();
		setVisible(true);
	}
	


	private void setUpUIComponent() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setUpEventListenr() {
		// TODO Auto-generated method stub
		setSize(640,480);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JNotePadUI();
	}

}