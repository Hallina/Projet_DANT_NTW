import java.util.ArrayList;
import index.*;


public class Main {

	public static void main(String[] args) {
		Table maTable = new Table("Test");
		ArrayList<Index> mesIndexes = maTable.getIndexes();
		
		try {
			new CSVParser("C:\\Users\\yasse\\Downloads\\test2.csv").separe_lines_champ();	
		}catch(Exception e) {
			e.printStackTrace();
			return;
		}
		
		for(int i = 0; i < CSVParser.getChamps().size(); i++) {
			maTable.ajouterIndex();
		}
		System.out.println("le nombre de champs du fichier CSV est : " + CSVParser.getChamps().size());
		System.out.println("Donc le nombre d'index (colonnes) crées est : " + mesIndexes.size());

		int champPos = 0;
		int wc = 0;
		for(int j = 0; j < mesIndexes.size(); j++) {
			Index index = mesIndexes.get(j);
			for(int k = 0; k < CSVParser.getLines().size(); k++) {
				String word = CSVParser.getLines().get(k)[champPos];
				index.insert(word);
				
				System.out.println("Index " + index.getColumn() + " : " + word + ", " + ++wc + "e valeur indéxé");
			}
			champPos++;
		}
	}
}
