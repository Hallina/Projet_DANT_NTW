package index;

import java.io.*;
import java.util.ArrayList;

public class CSVParser {
	private static ArrayList<String[]> lines;
	private String path;
	
	public CSVParser(String path) {
		this.path = path;
		lines = new ArrayList<String[]>();
	}
	
	public void separe_lines_champ() {
		try {
		      FileReader fr = new FileReader(path);
		      BufferedReader br = new BufferedReader(fr);
		      //1ère lecture pour éviter la ligne des commentaires
		      String strCurrentLine = br.readLine();
		      while ((strCurrentLine = br.readLine()) != null) {
		    	  String[] s = strCurrentLine.split(",");
		    	  lines.add(s);
		      }
		      br.close();
		} catch (IOException e) {
		      e.printStackTrace();
		}
	}
	
	public static ArrayList<String[]> getLines(){
		return lines;
	}
}
