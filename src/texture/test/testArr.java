package texture.test;

import java.util.ArrayList;
import java.util.List;

public class testArr {

	
	
	public static void main(String[] args) {
		
		List<String> elements =new ArrayList<String>();
        elements.add("C");
        elements.add("SI");
        elements.add("Mn");
        elements.add("P");
        elements.add("S");
        elements.add("Cr");
        elements.add("Ni");
        elements.add("Mo");
        elements.add("Cu");

        int[]  arr=new int[elements.size()+2];
        arr[0]=3;
        for (int i = 0; i < elements.size(); i++) {
        	arr[i+1] =5;
		}
		arr[arr.length-1]=4;
		
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
