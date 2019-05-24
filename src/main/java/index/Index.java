package index;

import java.util.HashMap;
import java.util.ArrayList;
import Models.Where;

public class Index {
    private static int cpt_index = 0;
    private int id;
    private HashMap<Integer, IndexColumn> indexByColumns;
    public Index() {
    	id = cpt_index++;
        indexByColumns = new HashMap<>();
        indexByColumns.put(id, new IndexColumn());
    }
    
    public int getId() {
    	return id;
    }
    
    public HashMap<Integer, IndexColumn> getIndexByColumns(){
    	return indexByColumns;
    }

    public ArrayList<Object> getSearchArea(ArrayList<String> champs, ArrayList<Where> wheres) {
    	ArrayList<Object> res = new ArrayList<>();
        //Récupération de zone de recherche
        for (Where where : wheres) {
            int position = CSVParser.getChamps().indexOf(where);
            res.add(indexByColumns.get(position));
        }
        return res;
    }
/*
    // get without index
    public ArrayList<Object[]> getWithoutIndex(int colPosition, String value){
        //Full Scan
        ArrayList<Object[]> res = new ArrayList<>();
        for(Object[] line : CSVParser.getLines()){
            if (line[colPosition].equals(value)) {
                res.add(line);
            }
        }
        return res;
    }

    // Id without Index
    public ArrayList<Integer> getRowIdsWithoutIndex(int colPosition, String value){
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < CSVParser.getLines().size() ; i++){
            if (CSVParser.getLines().get(i)[colPosition].equals(value)) {
                res.add(i);
            }
        }
        return res;
    }*/
}
