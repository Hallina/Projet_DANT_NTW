package index;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CSVParser {
	private ArrayList<String[]> lines;
	private String path;
	private HashMap<Integer, String> champs;
	
	public CSVParser(String path) {
		this.path = path;
		lines = new ArrayList<>();
		champs = new HashMap<>();
	}
	
	public void separe_lines_champ() {
		try {
		      FileReader fr = new FileReader(path);
		      BufferedReader br = new BufferedReader(fr);
		      //1ère lecture pour lire les intitulés des champs
		      String strCurrentLine = br.readLine();
		      String[] list_champ = strCurrentLine.split(",");
		      
		      for(int i = 0; i < list_champ.length; i++) {
		    	  champs.put(i,list_champ[i]);
		      }
		      while ((strCurrentLine = br.readLine()) != null) {
		    	  String[] s = strCurrentLine.split(",");
		    	  lines.add(s);
		      }
		      br.close();
		} catch (IOException e) {
		      e.printStackTrace();
		}
	}
	
	public HashMap<Integer, String> getChamps(){
		return champs;
	}
	
	public ArrayList<String[]> getLines(){
		return lines;
	}
}
