import java.util.ArrayList;
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
			return;
		}
		
		for(int i = 0; i < c.getChamps().size(); i++) {
			maTable.ajouterIndex();
		}
		
		int champPos = 0;
		int wc = 0;
		for(int j = 0; j < mesIndexes.size(); j++) {
			Index index = mesIndexes.get(j);
			for(int k = 0; k < c.getLines().size(); k++) {
				//index.insert(c.getLines().get(k)[champPos]);
				System.out.println(wc++);
			}
			champPos++;
		}
	}
}
