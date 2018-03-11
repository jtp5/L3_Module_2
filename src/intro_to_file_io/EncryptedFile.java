package intro_to_file_io;

import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class EncryptedFile {
	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Enter a message.");
		String output = "";
		ArrayList<Character> charArray = new ArrayList<Character>();
		ArrayList<Integer> intArray = new ArrayList<Integer>();
		for (int i = 0; i < input.length(); i++) {
			charArray.add(input.charAt(i));
		}
		for (char c : charArray) {
			intArray.add(c + 10);
		}
		for (int i : intArray) {
			output += i + " ";
		}
		try {
			FileWriter writer = new FileWriter("src/intro_to_file_io/cool.txt");

			writer.write(output);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
