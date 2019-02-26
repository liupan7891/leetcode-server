package test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
 
public class LexicographicTArray extends ArrayList<Map<String,String>> {
	
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LexicographicTArray lexicographicTArray = new LexicographicTArray();
		
		
		Map<String,String > map = new HashMap<>();
		map.put("k1", "v1");
		map.put("k2", "v2");
		
		lexicographicTArray.add(map);
		map = new HashMap<>();
		map.put("A", "XXX");
		lexicographicTArray.add(map);
		
		String rt = lexicographicTArray.store();
		LexicographicTArray load = lexicographicTArray.load(rt);
	}
	
	/**
	 * 
	 * @return
	 */
	public String store() {
		String str = "";
		
		for(int i=0;i<this.size();i++) {
			Map<String,String> item = this.get(i);

			for(Map.Entry<String, String> entry:item.entrySet()){
				String k = entry.getKey();
				String v = entry.getValue();
				str += (k + "="+v+";");
			}
			str = str.substring(0, str.length()-1);
			str+="\\n";
		}
		
		str = str.substring(0, str.length()-2);
		System.out.println("运行结果： "+str.toString());
		return str;
	}
	
	/***
	 * 
	 * @param dictArrayText
	 * @return
	 */
	public LexicographicTArray load(String dictArrayText) {
		String arrays[] = dictArrayText.split("\\\\n");
		LexicographicTArray dictArr = new LexicographicTArray();
		for(String arrStr:arrays) {
			
			String kvs[] = getStringTArray(arrStr,";");
			Map<String,String> dic = new HashMap<>();
			for(String kv:kvs) {
				
				String kvPair[] = getStringTArray(kv,"=");
				dic.put(kvPair[0], kvPair[1]);
			}
			dictArr.add(dic);
		}
		return dictArr;
	}

	/**
	 * 字符串数组切割
	 * @param str
	 * @param split
	 * @return
	 */
	private static String[] getStringTArray(String str, String split){
		
		StringTokenizer token=new StringTokenizer(str,split);  
		
		String [] arrayStr = new String[token.countTokens()];
		int count =0;
				
        while(token.hasMoreElements()){
        	arrayStr[count] = (String) token.nextElement();
        	count++;
        }
        
        return arrayStr;
	}
}