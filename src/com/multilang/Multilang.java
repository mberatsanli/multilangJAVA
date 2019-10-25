package com.multilang;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.*;


/**
 * Multilang
 */
public class Multilang{
	
	/**
	 * language, seçilen dil dosyasý
	 */
    private String language = "tr";
    
    /**
     * Dil dosyalarýnýn dizini
     */
    private String directory = "languages/";

    /**
     * getLanguage
     * @return
     */
    public String getLanguage() {
        return this.language;
    }

    /**
     * setLanguage
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * getDirectory
     * @return
     */
    public String getDirectory() {
        return directory;
    }

    /**
     * setDirectory
     * @param directory
     */
    public void setDirectory(String directory) {
        this.directory = directory;
    }

    /**
     * Dil Dosyasý Kontrolü
     * @param fileLang
     * @return
     */
    public boolean control(String fileLang) {
        File f = new File(this.directory + fileLang + ".json");
        Boolean boolCtrl = f.exists();
        return boolCtrl;
    }

    /**
     * Dilleri Getir
     * @return Array
     */
    public ArrayList<String> getLanguages(){
        ArrayList<String> langs = new ArrayList<String>();
        
        File folder = new File(this.directory);
        for (File fileEntry : folder.listFiles()) 
        {
            if (!fileEntry.isDirectory() && fileEntry.getName().contains(".json")) 
            {
            	String[] exploded = fileEntry.getName().split(".json");
                langs.add(exploded[0]);
            }
        }
        return langs;
    }

    /**
     * Dilleri Getir
     * @param write
     * @return void
     */
    public void getLanguages(Boolean write){
        if (write != true)
        {
            this.getLanguages();
            return;
        }
        
        File folder = new File(this.directory);
        for (File fileEntry : folder.listFiles())
        {
        	if (!fileEntry.isDirectory() && fileEntry.getName().contains(".json"))
            	{
	            	String[] exploded = fileEntry.getName().split(".json");
	                System.out.println(exploded[0]);
	            }
        }
    }
    
    /**
     * Çaðýrmak istediðiniz String
     * @param call
     * @return void
     */
    public String call(String call) {
    	String contents;
    	String called;
	try {
		contents = new String(Files.readAllBytes(Paths.get(this.directory + this.language + ".json")));
		JSONObject o = new JSONObject(contents);
	   	called = o.getString(call);    	
	} catch (IOException e) {
		e.printStackTrace();
		called = "ERROR!";
	}
    	return called;
    }
  
}
