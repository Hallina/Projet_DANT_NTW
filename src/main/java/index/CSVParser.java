package index;

import java.io.*;
import java.util.ArrayList;

public class CSVParser {
	
	private String path;
	private static ArrayList<String[]> lines;
	private static ArrayList<String> champs;
	
	public CSVParser(String path) {
		this.path = path;
		lines = new ArrayList<>();
		champs = new ArrayList<>();
	}
	
	public void separe_lines_champ() {
		try {
		      FileReader fr = new FileReader(path);
		      BufferedReader br = new BufferedReader(fr);
		      //1ère lecture pour lire les intitulés des champs
		      String strCurrentLine = br.readLine();
		      String[] list_champ = strCurrentLine.split(",");
		      
		      for(int i = 0; i < list_champ.length; i++) {
		    	  champs.add(list_champ[i]);
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
	
	public static ArrayList<String> getChamps(){
		return champs;
	}
	
	public static ArrayList<String[]> getLines(){
		return lines;
	}
}
