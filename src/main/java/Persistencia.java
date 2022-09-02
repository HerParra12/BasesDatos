import java.io.*;
import java.util.*;

public class Persistencia {
	
	public Persistencia() {}
	
	public void writePerson(String name, double id) {
		ObjectOutputStream stream;
		try {
			File file = new File("data.bin");
			if(file.length() == 0)
				stream = new ObjectOutputStream(new FileOutputStream(file));
			else
				stream = new StreamOutputObject(new FileOutputStream(file, true));
			stream.writeObject(new Persona(name, id));
			stream.close();
		} catch(Exception error) {}
	}
	
		
	public <T> List <?> readListPerson() {
		List <Persona> lista = new ArrayList<>();
		try(ObjectInputStream stream = new ObjectInputStream(new FileInputStream("data.bin"))){
			Persona person;
			try {
				while(true) {
					person = (Persona) stream.readObject();
					lista.add(person);
				}
			} catch(EOFException fin) {}
		}catch(Exception error) {
			return Collections.emptyList();
		}
		return lista;
	}	
	
	
	public boolean isValid(String name) {
		return name.matches("^([A-Z]?[a-z]{2}[ ]?){1,}$");
	}
	
	public boolean isNumber(String number) {
		return number.matches("^[0-9]+$");
	}
	
	public boolean isNumberDecimal(String number) {
		return number.matches("^[0-9]+[.]?[0-9]*");
	}
}