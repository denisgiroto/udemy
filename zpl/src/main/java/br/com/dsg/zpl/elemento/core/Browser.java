package br.com.dsg.zpl.elemento.core;

import java.awt.Desktop;
import java.net.URL;

 class Browser {
	public static void get(Densidade densidade, String zpl) {
		String url = "http://api.labelary.com/v1/printers/" + densidade.getPontos() + "dpmm/labels/4x6/0/"
				+ zpl.replace("^", "%5E");
		Desktop desktop = Desktop.getDesktop();
		try {
			desktop.browse(new URL(url).toURI());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}