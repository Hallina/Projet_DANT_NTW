import index.*;


public class Main {

	public static void main(String[] args) {
		Table maTable = new Table("Test");
		try {
			new CSVParser("C:\\Users\\yasse\\Downloads\\yellow_tripdata_2018-12.csv").separe_lines_champ();
		}catch(Exception e) {
			e.printStackTrace();
		}
		for(int i = 0; i < CSVParser.getLines().size() ;i++) {
			maTable.ajouterIndex();
		}
		
		for(int j = 0; j < maTable.getIndexes().size(); j++) {
			System.out.println(maTable.getIndexes().get(j).getId());
		}
	}

}
