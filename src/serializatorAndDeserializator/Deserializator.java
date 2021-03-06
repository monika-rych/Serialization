package serializatorAndDeserializator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserializator {
    private String path;

    public Deserializator(String path){
        this.path = path;
    }

        public Object deserialize(String path) {
            Object o = null;
            FileInputStream fis = null;
            ObjectInputStream ois = null;

            try {
             fis = new FileInputStream(path);
                 ois = new ObjectInputStream(fis);
                o = ois.readObject();
            }catch (FileNotFoundException fileNotFoundException){
                fileNotFoundException.printStackTrace();
                System.out.println("Nie odnaleziono podanej sciezki pliku");
            }catch (IOException e){
                e.printStackTrace();
                System.out.println("Wystapil wyjatek wejscie wyjscia");
            }catch (ClassNotFoundException classNotFoundException){
                classNotFoundException.printStackTrace();
                System.out.println("Wpodanym pliku nie bylo obiektu klasy burger");
            }
            finally {
                try {
                    ois.close();
                }catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Wystapil wyjatek wejscie wyjscia");
                }
                try {
                    fis.close();
                }catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Wystapil wyjatek wejscie wyjscia");
                }

            }
        return o;
       }
}
