import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PruebaSecuencial {

	public static void main(String[] args) {
		//Creamos los objetos que queremos guardar en el fichero
		Persona p1 = new Persona("Edu","Farolo Garcia",45,1);
		Persona p2 = new Persona("Aitor","Tilla Solo",23,2);
		String ruta = "/home/pili/Documentos/PROGRAMACION/pruebasIO/pruebaPersonas1.ddr";
		Persona aux;
		
		try {
			
			FileOutputStream f = new FileOutputStream(ruta); // Este objeto permite escribir bytes de un fichero
			ObjectOutputStream oos = new ObjectOutputStream(f); // Permite escribir un objeto
			
			// Escribimos en el fichero los objetos
			oos.writeObject(p1);
			oos.writeObject(p2);
			
			oos.close(); // Cerramos el flujo				
			
		} catch(IOException e) {
			
		}
		
		try {
			FileInputStream fi = new FileInputStream(ruta); // Este objeto permite leer bytes de un fichero
			ObjectInputStream ois = new ObjectInputStream(fi); // Permite leer un objeto
			
			// Leemos el fichero los objetos
			while(true) {
				aux = (Persona) ois.readObject();
				System.out.println(aux.getNombre());
				System.out.println(aux.getApellidos());
				System.out.println(aux.getEdad());
				System.out.println(aux.getId());
				System.out.println("");
			} 
			
			// ois.close(); No deja cerrarlo
		} catch(ClassNotFoundException e){
        	
        } catch(EOFException e){
        	
        } catch(IOException e){
        	
        }

	}

}
