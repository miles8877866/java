
public class EscapeValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch = '\u5b57';//16�i�줤5b57�O'�r'��Unicode �s�X
		System.out.println("�ܼ�ch �����e��:"+ ch);
		
		ch = '\\';//�ϱ׽u  \
		System.out.println("�ܼ�ch �����e��:"+ch);
		
		ch = '\''; //��޸�  '
		System.out.println("�ܼ�ch �����e��: "+ch);
	}

}
