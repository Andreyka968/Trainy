import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.Computer;
import com.example.computerName.*;

public class Main {
    private static final String FILENAME = "resources/computer1.csv";
    private static Computer sybernova;

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
                sb.append((char) c);
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString().split(System.lineSeparator());
    }

    private static String[] readFileToArray(String filename) throws FileNotFoundException {
        List<String> data = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File(FILENAME))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                data.add(line);
            }
        }
        return data.toArray(String[]::new);
    }

    static String[] readFileUsingScanner(String filename) {
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

    private static List<Computer> createdObject(String[] data) {
        List<Computer> myList = new ArrayList<>();
        for (int c = 2; c < data.length; c++) {
            var peaces = data[c].split(";");
            Computer sybernova = null;
            switch (peaces[2]) {
                case "CyberNova_1":
                    sybernova = new CyberNova
                            (Integer.parseInt(peaces[0]) , peaces[5] , peaces[2] , peaces[1] ,
                                    peaces[4] , peaces[3] ,
                                    Integer.parseInt(peaces[6]));
                    break;
                case "NexusWave_2":
                    sybernova = new NexusWave(Integer.parseInt(peaces[0]) , peaces[5] , peaces[2] , peaces[1] ,
                            peaces[4] , peaces[3] ,
                            Integer.parseInt(peaces[6]));
                    break;
                case "QuantumPulse_3":
                    sybernova = new QuantumPulse(Integer.parseInt(peaces[0]) , peaces[5] , peaces[2] , peaces[1] ,
                            peaces[4] , peaces[3] ,
                            Integer.parseInt(peaces[6]));
                    break;
                case "StellarByte_4":
                    sybernova = new StellarByte(Integer.parseInt(peaces[0]) , peaces[5] , peaces[2] , peaces[1] ,
                            peaces[4] , peaces[3] ,
                            Integer.parseInt(peaces[6]));
                    break;
                case "VirtuosoSystem_6":
                    sybernova = new VirtuosoSystem(Integer.parseInt(peaces[0]) , peaces[5] , peaces[2] , peaces[1] ,
                            peaces[4] , peaces[3] ,
                            Integer.parseInt(peaces[6]));
                    break;
                case "TechMaverick_5":
                    sybernova = new TechMaverick(Integer.parseInt(peaces[0]) , peaces[5] , peaces[2] , peaces[1] ,
                            peaces[4] , peaces[3] ,
                            Integer.parseInt(peaces[6]));
                    break;
            }
            myList.add(sybernova);
        }
        return myList;
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<Computer> myList = new LinkedList<>();
        String[] data = readFileUsingFileReader(FILENAME);
        myList = createdObject(data);
        //Сортировка с условием SortSkip и SortOut.
        Stream<Computer> stream = myList.stream();
        stream
                .sorted((c1 , c2) -> (int) (c1.getId() - c2.getId()))
                .skip(17)
                .limit(21)
                .forEach(System.out::println);

//      Фильтрация в количестве FilterOot.
        Stream<Computer> stream1 = myList.stream();
        stream1
                .filter(cam -> cam.getHascam() >= 1)
                .limit(11)
                .forEach(System.out::println);

        //Создание обьекта Map из стрима.
        Stream<Computer> stream2 = myList.stream();
        Map<Integer, String> compMap = stream2.collect(Collectors.toMap(Computer::getId ,
                Computer::getComputerName));
        compMap.forEach((key , value) -> System.out.println
                ("ID: " + key + ", Computer Name: " + value));
    }
}
