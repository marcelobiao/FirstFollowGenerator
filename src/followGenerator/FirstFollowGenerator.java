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
		System.out.println(key);
		Iterator<ArrayList<String>> prods = this.dict.get(key).iterator();
		ArrayList<String> firsts = new ArrayList<String>();
		while(prods.hasNext()){
			Iterator<String> elementos = ((ArrayList<String>)prods.next()).iterator();
			while(elementos.hasNext()){//TODO: não precisa do loop, só precisa olhar o primeiro aqui
				String temp = elementos.next().toString();
				if(this.isTerminal(temp)){
					if(!firsts.contains(temp))
						firsts.add(temp);
					break;
				}
				else if(temp.contains("E")){
					if(!firsts.contains("E"))
						firsts.add("E");
					break;
				}
				else{
					firsts = this.mergeArraylist(firsts, firstUnit(temp));
					if(!this.containsE(temp))
						break;
				}
			}
		}
		return firsts;
	}
	
	public ArrayList<String> mergeArraylist(ArrayList<String> a, ArrayList<String> b){
		//TODO: Consertar o armengue de não precisar adicionar o E nas chamadas recursivas.
		Iterator iteratorB = b.iterator();
		while (iteratorB.hasNext()){
			String element = iteratorB.next().toString();
			if(!a.contains(element) && !element.equals("E"))
				a.add(element);
		}
		return a;
	}
	
	public boolean containsE(String key){
		Iterator<ArrayList<String>> prods = this.dict.get(key).iterator();
		while(prods.hasNext()){
			if(prods.next().contains("E")){
				return true;
			}
		}
		return false;
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