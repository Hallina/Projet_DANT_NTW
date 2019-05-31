package index;

import java.util.HashMap;

public class Index {
    private static int cpt_index = 0;
    private int position;
    private HashMap<Integer, String> values;
  
    public Index() {
    	position = cpt_index++;
        values = new HashMap<>();
    }
    
    public int getPosition() {
    	return position;
    }
    
    public HashMap<Integer, String> getValues() {
    	return values;
    }

    public void insert(String value){
    	int i = 0;
    	while(values.containsKey(i)) {
    		i++;
    	}
        values.put(i,value);
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
