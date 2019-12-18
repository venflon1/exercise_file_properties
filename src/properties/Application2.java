package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Application2 {

	public static void main(String[] args) {
		
		File file = null; 
		FileInputStream fis = null;
		
		try {
			file = new File("..\\properties\\resource\\props.xml");
			fis = new FileInputStream(file);
			Properties props = new Properties();
			props.loadFromXML(fis);
			
			String marca = (String) props.get("marca");
			String modello = (String) props.get("modello");
			double cilindrata = Double.parseDouble((String) props.get("cilindrata"));
			int cavalli = Integer.parseInt((String)props.get("cavalli"));
			
			Auto p = new Auto(marca, modello, cilindrata, (short)cavalli);
			System.out.println(p);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}

class Auto{
	private String marca;
	private String modello;
	private double cilindrata;
	private short cavalli;
	
	public Auto() {
		super();
	}

	public Auto(String marca, String modello, double cilindrata, short cavalli) {
		this();
		this.marca = marca;
		this.modello = modello;
		this.cilindrata = cilindrata;
		this.cavalli = cavalli;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public double getCilindrata() {
		return cilindrata;
	}

	public void setCilindrata(double cilindrata) {
		this.cilindrata = cilindrata;
	}

	public short getCavalli() {
		return cavalli;
	}

	public void setCavalli(short cavalli) {
		this.cavalli = cavalli;
	}

	@Override
	public String toString() {
		return "Auto [marca=" + marca + ", modello=" + modello + ", cilindrata=" + cilindrata + ", cavalli=" + cavalli
				+ "]";
	}
}
