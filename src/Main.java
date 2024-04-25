import login.*;
import classes.*;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) {
		signInGUI frame = new signInGUI();
		frame.setVisible(true);
		frame.setSize(500,500); 
	}
}