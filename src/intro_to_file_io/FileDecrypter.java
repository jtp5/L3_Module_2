package intro_to_file_io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class FileDecrypter {
	public static void main(String[] args) {
		String message = "";
		String fileName = "";
		ArrayList<Character> charList = new ArrayList<Character>();
		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			fileName = jfc.getSelectedFile().getAbsolutePath();
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));

			message = br.readLine();

			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int track = 0;
		for (int i = 0; i < message.length(); i++) {
			if (message.charAt(i) == ' ') {
				track++;
			}
		}
		int place = 0;
		for (int i = 0; i < track; i++) {
			charList.add((char) (Integer.parseInt(message.substring(place, message.indexOf(' ', place))) - 10));
			place = message.substring(place, message.indexOf(' ', place)).length() + 2;
		}
		for (char c : charList) {
			System.out.print(c);
		}

	}
}
