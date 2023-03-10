package utilities;

import java.io.File;
import java.util.Vector;

public class Package {
    //
    Vector<String> allPackage = new Vector<String>();

    public Vector<String> getAllPackage(String folder) {
        // x
        System.out.println("Path = " + folder);
        Vector<String> result = new Vector<String>();
        File directoryPath = new File(folder);
        String[] folders = directoryPath.list();
        //
        for (int i = 0; i < folders.length; i++) {
            System.out.println(folders[i]);
            if (getFolder(folders[i])) {
                this.allPackage.add(folders[i]);
                getAllPackage(folders[i]);
            }
        }
        return result;
    }

    public void showPackage() {
        for (String pack : this.allPackage) {
            System.out.println(pack);
        }
    }

    public static boolean getFolder(String folder) {
        File file = new File(folder);
        if (file.isDirectory()) {
            return true;
        } else {
            return false;
        }
    }

    public Vector<String> getAllPackage() {
        return allPackage;
    }

    public void setAllPackage(Vector<String> allPackage) {
        this.allPackage = allPackage;
    }

}
