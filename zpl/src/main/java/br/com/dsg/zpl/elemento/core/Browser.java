package br.com.dsg.zpl.elemento.core;

import java.awt.Desktop;
import java.net.URL;

public class Browser {
    public static void get(int densidade,String zpl ) {
        String url = "http://api.labelary.com/v1/printers/"+densidade+"dpmm/labels/4x6/0/"+zpl.replace("^", "%5E");
//        String url = "http://api.labelary.com/v1/printers/8dpmm/labels/4x6/0/%5EXA%5ELL560%5EFO80,80%5EGB240,40,8,B%5EFS%5EXZ"
//        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URL(url).toURI());
            } catch (Exception e) {
                e.printStackTrace();
            }
//        }else{
//            Runtime runtime = Runtime.getRuntime();
//            try {
//            	String[] cmd = new String[4];
//            	cmd[0] = "firefox.exe";
//            	cmd[1] = "/C";
//            	cmd[2] = "start";
//            	cmd[3] = url;
//                runtime.exec(url);
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
    }
}