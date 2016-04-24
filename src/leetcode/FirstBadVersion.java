package leetcode;


/**
278. First Bad Version

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

순차로 접근 시 시간 초과, 이분법으로 계산
 * @author nnoco
 *
 */
public class FirstBadVersion extends VersionControl{
	public FirstBadVersion(int n, int firstBadVersion) {
		super(n, firstBadVersion);
	}
	
	public static void main(String[] args) {
		FirstBadVersion fbv = new FirstBadVersion(2_126_753_390,1_702_766_719);
		fbv.printInformations();
		int firstBadVersion = fbv.firstBadVersion(fbv.n);
		System.out.println(firstBadVersion);
	}
	public int firstBadVersion(int n) {
		int min = 1, max = n;
		int current;
		
		while(max - min > 1) {
			current = min + (max - min) / 2;
			
			if(isBadVersion(current)) {
				max = current;
			} else {
				min = current;
			}
		}
		
		return !isBadVersion(min) && isBadVersion(max) ? max : min;
	}
}

class VersionControl {
	protected int n;
	protected int firstBadVersion;
	
	public VersionControl(int n, int firstBadVersion) {
		this.n = n;
		this.firstBadVersion = firstBadVersion;
	}
	
	boolean isBadVersion(int version) {
		return version >= firstBadVersion;
	}
	
	void printInformations() {
		System.out.println("n: " + n + ", first bad version: " + firstBadVersion);
	}
}
