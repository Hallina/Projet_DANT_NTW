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
}
