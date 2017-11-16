
public class Test {

	public static void main(String[] args) {
		Disk disk = new Disk(2);
		Disk disk2 = null;
		
		System.out.println(disk);
		System.out.println(disk2);
		System.out.println(disk.compareTo(disk2));
	}

}
