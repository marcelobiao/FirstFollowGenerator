package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import followGenerator.FirstFollowGenerator;
import followGenerator.ProcGLC;
import util.Debug;

public class main {
	public static void main (String []args){
		String path = ".\\files\\teste.txt";		
		ProcGLC p = null;
		Debug.setDebugOff();
		try {
			p = new ProcGLC(path);
			p.read();
			FirstFollowGenerator generator = new FirstFollowGenerator(p.getDict());
			generator.firstGenerator();
			Map<String, ArrayList<String>> firsts = generator.getFirst();
			System.out.println(firsts);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
}