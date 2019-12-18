package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Application {
	
	public static void main(String[]args) {
		
		File file = null; 
		FileInputStream fis = null;
		
		try {
			file = new File("..\\properties\\resource\\data.properties");
			fis = new FileInputStream(file);
			Properties props = new Properties();
			props.load(fis);
			
			String nome = (String) props.get("nome");
			String surname = (String) props.get("cognome");
			int age = Integer.parseInt((String)props.get("eta"));
			
			Persona p = new Persona(nome, surname, age);
			System.out.println(p.toString());
			
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

class Persona{
	String name;
	String surname;
	int age;
	
	public Persona() {
		super();
	}
	
	public Persona(String name, String surname, int age) {
		this();
		this.name = name;
		this.surname = surname;
		this.age = age;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Persona [name=" + name + ", surname=" + surname + ", age=" + age + "]";
	}
}