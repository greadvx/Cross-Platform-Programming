package by.bsuir.Khamutouski.system;

import javax.swing.filechooser.FileFilter;
import java.io.File;
/**
 * <h1>File limiter</h1>
 * <p>
 * This is a imageFileFilter class of application
 * that model real teaching process
 * </p>
 * This class is used to limit type of images,
 * than can be used as photo profile.
 *
 * @author Yan Khamutouski
 * @version 2.0
 * @since 2018-03-16
 *
 * */
public class ImageFileFilter extends FileFilter {
    /**
     * {@value #TYPE_OF_FILE} Type of image file.
     * */
    private static final String TYPE_OF_FILE = "jpg";
    /**
     * This method contains code written to know
     * is this file equal to needs.
     * @param chosenFile file that chosen by user.
     * @return boolean true or false.
     * */
    public boolean accept(final File chosenFile) {
        if (chosenFile != null) {
            String name = chosenFile.getName();
            int i = name.lastIndexOf('.');
            if (i > 0 && i < name.length() - 1) {
                return name.substring(i + 1).equalsIgnoreCase(TYPE_OF_FILE);
            }
        }
        return false;
    }
    /**
     * This method contains code written to know
     * what type of file needed.
     * @return String description of file.
     * */
    public String getDescription() {
        return "Image";
    }
}
