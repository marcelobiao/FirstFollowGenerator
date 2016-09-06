package followGenerator;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

import util.Debug;

public class ProcGLC {
	private Map<String, ArrayList<ArrayList<String>>> dict = new Hashtable<String, ArrayList<ArrayList<String>>>();
	private String path;
	private FileReader file;
	
	public ProcGLC(String path) throws IOException{
		this.path = path;
	}
	
	/*
		<Program> ::= <Expr_Relacional_Booleana>  
		<Expr_Relacional_Booleana> ::= <Expr_Conjunta> <Expr_Conjunta_I> | <Nada>
		<Expr_Conjunta> ::= <Expr_Relacional> <Expr_Relacional_I>
	 */
	
	public void read() throws IOException{
		String line;
		file = new FileReader(this.path);
		BufferedReader buffer = new BufferedReader(file);
		line = buffer.readLine();
		
		while(line != null){
			String[] regra = line.split("::=");
			//TODO: Resolver IndexOutOfBound, causado pro entradas sem ::=
			String[] prodsTex = regra[1].trim().split("\\|" );
			
			ArrayList<ArrayList<String>> prods = new ArrayList<ArrayList<String>>();
			
			for(int i=0; i<prodsTex.length;i++){
				ArrayList<String> prod = new ArrayList<String>();
				List<String> strings = Arrays.asList(prodsTex[i].split(" "));
				for (String s : strings) {
					if (!(s == null || s.trim().isEmpty()))
						prod.add(s);
				}
				prods.add(prod);
			}
			Debug.print(""+prods.size());
			this.dict.put(regra[0].trim(), prods);
			line = buffer.readLine();
		}
		file.close();
	}
	
	public void printGLC(){
		for (String key : this.dict.keySet()){
			System.out.println(key+"->"+this.dict.get(key).toString());
		}
	}
	
	public Map<String, ArrayList<ArrayList<String>>> getDict(){
		return this.dict;
	}
	
}
