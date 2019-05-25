import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;

public class PruebaAccesoDirecto {

	public static void main(String[] args) {
		String ruta = "/home/pili/Documentos/PROGRAMACION/pruebasIO/pruebaPersonas2.ddr";
		long pos1, pos2, pos3, pos4;
		
		Persona p1 = new Persona("Elisa","Garcia Cubero",25,1);
		Persona p2 = new Persona("Pablo","Rodriguez Armida",27,2);
		Persona p3 = new Persona("Alberto","Ruiz Gallardón",21,3);
		Persona p4 = new Persona("Ana","Sersic Sánchez",18,4);
		
		Persona aux;
		
		// Preparo las posiciones en las que va a ir cada objeto Persona
		pos1 = p1.getId()*1000;
		pos2 = p2.getId()*1000;
		pos3 = p3.getId()*1000;
		pos4 = p4.getId()*1000;
		
		try {
			RandomAccessFile raf = new RandomAccessFile(ruta, "rw"); // Objeto que se utiliza para acceder a un fichero de forma aleatoria
			
			FileOutputStream fos = new FileOutputStream(raf.getFD()); // Recibe el fichero de acceso directo
			
			ObjectOutputStream oos = new ObjectOutputStream(fos); // Recibe el fichero
			
			raf.seek(pos1); // Coloco el puntero
			oos.writeObject(p1); // Guardo la primera persona en el fichero
			
			raf.seek(pos2); // Coloco el puntero
			oos.writeObject(p2); // Guardo la segunda persona en el fichero
			
			raf.seek(pos3); // Coloco el puntero
			oos.writeObject(p3); // Guardo la tercera persona en el fichero
			
			raf.seek(pos4); // Coloco el puntero
			oos.writeObject(p4); // Guardo la cuarta persona en el fichero
			
			oos.close(); // Cierro el flujo
			
		} catch(FileNotFoundException e) {
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			RandomAccessFile raf = new RandomAccessFile(ruta, "rw"); // Objeto que se utiliza para acceder a un fichero de forma aleatoria
			
			FileInputStream fis = new FileInputStream(raf.getFD()); // Recibe el fichero de acceso directo
			
			ObjectInputStream ois = new ObjectInputStream(fis); // Recibe el fichero
			
			raf.seek(pos2);
			aux = (Persona) ois.readObject();
			if (aux.getId() == 3) {
					System.out.println(aux.getNombre());
					System.out.println(aux.getApellidos());
					System.out.println(aux.getEdad());
			}
			
			
		} catch(FileNotFoundException e) {
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
