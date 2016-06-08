import java.io.IOException;
import java.util.PropertyResourceBundle;


public class ProgramProperties_sp extends PropertyResourceBundle {

  public ProgramProperties_sp() throws IOException {
    super(ProgramProperties_sp.class.getResourceAsStream("ProgramProperties_sp.txt"));
  }
}

