package by.bsuir.Khamutouski;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class ImageFileFilter extends FileFilter{

    private final static String TYPE_OF_FILE = "jpg";

    public boolean accept(File chosenFile){
        if (chosenFile != null){
            String name = chosenFile.getName();
            int i = name.lastIndexOf('.');
            if (i>0 && i < name.length() - 1)
            return name.substring(i + 1).equalsIgnoreCase(TYPE_OF_FILE);
        }
        return false;
    }
    public String getDescription() {
        return "Image";
    }
}
