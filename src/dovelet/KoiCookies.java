package dovelet;

import java.util.Scanner;

/**
 * http://59.23.113.171/pool/koi_cookies/koi_cookies.php?pname=koi_cookies
 * @author nnoco
 */
public class KoiCookies {
	public static void main(String[]args) {
		Scanner s=new Scanner(System.in);
		int p=s.nextInt()*s.nextInt(), m=s.nextInt();
		System.out.println(p-m < 0 ? 0 : p-m);
		
		s.close();
	}
}

