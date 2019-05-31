import java.util.ArrayList;
import java.util.HashMap;
import index.*;


public class Main {

	public static void main(String[] args) {
		Table maTable = new Table("Test");
		ArrayList<Index> mesIndexes = maTable.getIndexes();
		CSVParser c = null;
		try {
			c = new CSVParser("C:\\Users\\yasse\\Downloads\\test.csv");
			c.separe_lines_champ();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < c.getLines().size(); i++) {
			maTable.ajouterIndex();
		}
		
		for(int j = 0; j < mesIndexes.size(); j++) {
			Index index = mesIndexes.get(j);
			HashMap<Integer, String> hm = index.getValues();
		}
	}
}
