package com.unice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**Basé sur un code de Mireille Blay*/
public class Save {
	/**Save an object into a file
	 * @param oToSave the object to save
	 * @param fileName the destination file*/
    public static void save (Object oToSave, String fileName){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(oToSave);
            oos.flush();
        } catch (final java.io.IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.flush();
                    oos.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**Read an object from a file
     * @param fileName the source file*/
    public static Object read (String fileName){
        ObjectInputStream ois = null;
        Object o = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(fileName));
            o = ois.readObject();
            //System.out.println(o);
        } catch (final java.io.FileNotFoundException e) {
            System.out.println("Aucune sauvegarde antèrieure existante");
        } catch (final java.io.IOException e) {
            e.printStackTrace();
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }
        return o;
    }
}