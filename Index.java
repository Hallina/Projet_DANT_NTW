//VendorID,tpep_pickup_datetime,tpep_dropoff_datetime,passenger_count,trip_distance,RatecodeID,store_and_fwd_flag,PULocationID,DOLocationID,payment_type,fare_amount,extra,mta_tax,tip_amount,tolls_amount,improvement_surcharge,total_amount
//1,2018-12-01 00:28:22,2018-12-01 00:44:07,2,2.50,1,N,148,234,1,12,0.5,0.5,3.95,0,0.3,17.25

import java.util.ArrayList;
import java.util.HashMap;

public class Index {
	private ArrayList<Object[]> lines;
	private HashMap<String,ArrayList<Integer>> index;

	public void insert(Object[] line){
		int nb_line = lines.size();
		lines.add(line);
		ArrayList<Integer> rows = index.get(line[0]);
		if (rows == null){
			rows = new ArrayList<Integer>();
			index.put(line[0], rows);
		}
		rows.add(nb_line);
	}

	public ArrayList<Object[]> get(String key){
		ArrayList<Integer> rows = index.get(key);
		if(rows == null){
			return null;
		}
		ArrayList<Object[]> res = new ArrayList<Object[]>();
		for(Integer row : rows){
			res.add(lines.get(row));
		}
		return res;
	}

	public ArrayList<Object[]> getWithoutIndex(String key){
		ArrayList<Object[]> res = new ArrayList<Object[]>();
		for(Object[] line : lines){
			if(line[0].equals(key)){
				res.add(line);
			}
		}
		return res;
	}
}