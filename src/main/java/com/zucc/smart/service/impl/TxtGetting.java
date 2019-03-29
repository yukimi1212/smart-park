package com.zucc.smart.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class TxtGetting {

    public static ArrayList<String> getID() throws IOException {

    	String filePath = "C:\\Users\\milly\\Desktop\\errorID.txt";
    	File file = new File(filePath);
    	BufferedReader input=new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream (file))));
    	
    	ArrayList<String> listID = new ArrayList<String>();
        String line = null;  
        //逐行读取，逐行输出   
        for (long lineCounter = 0; (line = input.readLine()) != null; lineCounter++)  
        {  
        	listID.add(line);
        }  
        input.close();
        
        return listID;
    }

}
