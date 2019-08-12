package csDataStruct;

public class Main {

	public static void main(String[] args) {
		Array a = new Array<Integer>();

		for(int i=0;i<10;i++){
			a.addLast(i);
		}
		
		System.out.println(a);
		
		a.add(3, 5);
		System.out.println(a);
	}

}
