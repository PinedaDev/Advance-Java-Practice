package Challenge1.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Reader {
  private String path = null;
  private List<String[]> lines = new ArrayList<>();

  public Reader(String path) throws FileNotFoundException {
    this.path = path;
  }

  public List<String[]> getLines() {
    return lines;
  }
  public void readFile() {
    try {
      File file = new File(path);
      Scanner fileScanner = new Scanner(file);

      while (fileScanner.hasNext()) {
        String line = fileScanner.nextLine();
        if (!line.startsWith("Employee") && !line.equals("")) {
          String[] usersInfo = line.split(",");
          lines.add(usersInfo);
        }
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
