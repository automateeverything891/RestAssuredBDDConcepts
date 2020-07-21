package serializationANDdeserialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//impliment Serializable INterface for the Object Class
class Test implements Serializable
{
	int i=10, j=20;
}

public class Serialization_DeSerialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Test t1=new Test();
		
		//Serialization
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\java\\serializationANDdeserialization\\testFile.txt");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		
		oos.writeObject(t1);
		
		//De-Serialization
		FileInputStream fis=new FileInputStream(".\\src\\test\\java\\serializationANDdeserialization\\testFile.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		
		Test t2=(Test) ois.readObject();	
		System.out.println("i from t2 ="+t2.i);
		System.out.println("j from t2 ="+t2.j);
		
	}

}
