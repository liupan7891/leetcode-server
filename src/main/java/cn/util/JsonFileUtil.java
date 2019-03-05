package cn.util;

import java.util.Scanner;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class JsonFileUtil {

	private  Resource data;

	public  String getAppResources() {
		String jsonData ="";
        try {
        	BufferedReader br = new BufferedReader(new InputStreamReader(data.getInputStream()));
			StringBuffer message = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				message.append(line);
			}
			String defaultString = message.toString();
			jsonData = defaultString.replace("\r\n", "").replaceAll(" +", "");
			System.out.println(jsonData);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return jsonData;
	}
	
	 /**
     *     读取文件类容为字符串
     * @param file
     * @return
     */
      private static String jsonRead(File file){
            Scanner scanner = null;
            StringBuilder buffer = new StringBuilder();
            try {
                scanner = new Scanner(file, "utf-8");
                while (scanner.hasNextLine()) {
                    buffer.append(scanner.nextLine());
                }
            } catch (Exception e) {
                
            } finally {
                if (scanner != null) {
                    scanner.close();
                }
            }
            return buffer.toString();
        }


}
