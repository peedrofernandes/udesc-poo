package uteis;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileHandling {
  public static File inputStreamToFile(InputStream input, String path) throws IOException {
    try {
      File file = new File(path);
      OutputStream output = new FileOutputStream(file, false); // append: false;
      input.transferTo(output);
      return file;
    } catch (IOException exc) {
      System.err.println("Houve um erro ao copiar um fluxo de dados para um arquivo! " + exc.getMessage());
    }
    return null;
  }
}
