import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.List;

import com.example.Computer;
import com.example.computerName.*;

public class Main {
    private static final String FILENAME = "resources/computer";

    static String[] readFileUsingFileReader(String filename) {
        var newLine = System.lineSeparator();
        var sb = new StringBuffer();
        FileReader reader;

        try {
            reader = new FileReader(filename);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            reader.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int c;
        try {
            while ((c = reader.read()) != -1) {
                sb.append((char)c);
            }
            reader.close();}
        catch(IOException e){
                throw new RuntimeException(e);
            }
            return sb.toString().split(System.lineSeparator());
        }

        private static String[] readFileToArray (String filename) throws FileNotFoundException {
            List<String> data = new ArrayList<>();

            try (Scanner scanner = new Scanner(new File(FILENAME))) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    data.add(line);
                }
            }
            return data.toArray(String[]::new);
        }


        static String[] readFileUsingScanner (String filename){
            ArrayList<String> data = new ArrayList<String>();
            var file = new File(filename);
            Scanner scanner = null;
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            boolean finished = false;
            do {
                try {
                    data.add(scanner.nextLine());
                    ;
                } catch (NoSuchElementException e) {
                    finished = true;
                }
            }
            while (!finished);
            scanner.close();
            return Arrays.copyOf(data.toArray() , data.size() , String[].class);
        }

        public static void main (String[]args) throws FileNotFoundException {
            String[] data = readFileUsingFileReader(FILENAME);
            createdObject(data);
        }

    private static void createdObject(String[] data) {
        for (int c = 2; c < data.length; c++) {
            var peaces = data[c].split(";");
            Computer sybernova = null;
            switch (peaces[1]) {
                case "CyberNova_1":
                    sybernova = new CyberNova(peaces[4] , peaces[1] , peaces[0] ,
                            peaces[3] , peaces[4] ,
                            peaces[5]);
                    break;
                case "NexusWave_2":
                    sybernova = new NexusWave(peaces[4] , peaces[1] , peaces[0] ,
                            peaces[3] , peaces[4] ,
                            peaces[5]);
                    break;
                case "QuantumPulse_3":
                    sybernova = new QuantumPulse(peaces[4] , peaces[1] , peaces[0] ,
                            peaces[3] , peaces[4] ,
                            peaces[5]);
                    break;
                case "StellarByte_4":
                    sybernova = new StellarByte(peaces[4] , peaces[1] , peaces[0] ,
                            peaces[3] , peaces[4] ,
                            peaces[5]);
                    break;
                case "VirtuosoSystem_6":
                    sybernova = new VirtuosoSystem(peaces[4] , peaces[1] , peaces[0] ,
                            peaces[3] , peaces[4] ,
                            peaces[5]);
                    break;
                case "TechMaverick_5":
                    sybernova = new TechMaverick(peaces[4] , peaces[1] , peaces[0] ,
                            peaces[3] , peaces[4] ,
                            peaces[5]);
                    break;
            }
            System.out.println(sybernova);
        }
    }
}
