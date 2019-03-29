package index;

import Models.Where;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Index {

    private List<Object[]> lines;
    // Column Position by Index for one column
    private Map<Integer, IndexColumn> indexByColumns = new HashMap<>();

    public Index(List<Object[]> lines) {
        this.lines = lines;
    }

    public void insert(Object[] line) {
        for (Map.Entry<Integer, IndexColumn> indexColumn : indexByColumns.entrySet()) {
            int colPos = indexColumn.getKey();
            String value = line[colPos].toString();
            indexColumn.getValue().insert(value);
        }
    }

    public List<Object[]> get(List<String> colNames, List<Where> wheres) {
        for (Where where : wheres) {
            int position = colNames.indexOf(where.getField());
            if (position == -1) {
                getRowIdsWithoutIndex(position, where.getValue());
            } else {
                indexByColumns.get(position).get(where.getValue());
            }
        }
    }

    public List<Object[]> getWithoutIndex(int colPosition, String value){
        List<Object[]> res = new ArrayList<>();
        for(Object[] line : lines){
            if (line[colPosition].equals(value)) {
                res.add(line);
            }
        }
        return res;
    }


    public List<Integer> getRowIdsWithoutIndex(int colPosition, String value){
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < lines.size() ; i++){
            if (lines.get(i)[colPosition].equals(value)) {
                res.add(i);
            }
        }
        return res;
    }

}
