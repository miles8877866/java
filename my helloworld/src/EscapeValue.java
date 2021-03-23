
public class EscapeValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ch = '\u5b57';//16進位中5b57是'字'的Unicode 編碼
		System.out.println("變數ch 的內容為:"+ ch);
		
		ch = '\\';//反斜線  \
		System.out.println("變數ch 的內容為:"+ch);
		
		ch = '\''; //單引號  '
		System.out.println("變數ch 的內容為: "+ch);
	}

}
