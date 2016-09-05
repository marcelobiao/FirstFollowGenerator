package followGenerator;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class FirstFollowGenerator {
	private Map<String, ArrayList<ArrayList<String>>> dict;
	private Map<String, ArrayList<String>> first = new Hashtable<String, ArrayList<String>>();
	private Map<String, ArrayList<String>> follow = new Hashtable<String, ArrayList<String>>();
	
	public FirstFollowGenerator(Map<String, ArrayList<ArrayList<String>>> dict){
		this.dict = dict;
	}
	
	public void firstGenerator(){
		for (String key : this.dict.keySet()){//Percorre regras
			this.first.put(key, firstUnit(key));
		}
	}
	
	public void followGenerator(String key){
		
	}
	
	public ArrayList<String> firstUnit(String key){
		Iterator<ArrayList<String>> prods = this.dict.get(key).iterator();
		ArrayList<String> firsts = new ArrayList<String>();
		while(prods.hasNext()){
			Iterator<String> elementos = ((ArrayList<String>)prods.next()).iterator();
			while(elementos.hasNext()){
				String temp = elementos.next().toString();
				if(this.isTerminal(temp)){
					firsts.add(temp);
				}
			}
		}
		return firsts;
	}
	
	public boolean isTerminal(String elemento){
		if(elemento.endsWith("'"))
			return true;
		else
			return false;
	}
	
	public Map<String, ArrayList<String>> getFirst(){
		return this.first;
	}
	
	public Map<String, ArrayList<String>> getFollow(){
		return this.follow;
	}
	
	
}