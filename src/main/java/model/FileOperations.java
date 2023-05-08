package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOperations {

    public ArrayList<Questions> readFile() {

        ArrayList<Questions> questions = new ArrayList<>();

        File file = new File("Java Project Questions.csv");

            //read Java Project Questions.csv
            try {
                Scanner scanner = new Scanner(file);

                while (scanner.hasNext()) {

                    String[] data = scanner.nextLine().split(",");

                    Questions que = new Questions(data[0], data[1], data[2], data[3], data[4], data[5]);
                    questions.add(que);

                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();

            }

        return questions;
    }

}
