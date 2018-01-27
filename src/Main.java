import java.io.*;

public class Main {
    private int col;
    private int finalNum;

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        readFile();
        searchNumber();
        writeFile();
    }

    private void readFile(){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"))){
            col = Integer.parseInt(bufferedReader.readLine());
        } catch (FileNotFoundException e) {
            System.out.println("file or lines not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void searchNumber(){
        int value = 1;

        for (int i = 0; i < col; i++) {
            if (isBadNumber(value)) {
                value++;
                i--;
            } else if (i == col - 1) break;
            else value++;
        }

        finalNum = value;
    }

    private boolean isBadNumber(int i) {
        boolean isBad = false;
        String[] arr = Integer.toString(i).split("");

        for (int j = 0; j < arr.length - 1; j++) {
            for (int k = j + 1; k < arr.length; k++) {
                if (arr[j].equals(arr[k])) {
                    isBad = true;
                    break;
                }
            }
            if (isBad) break;
        }

        return isBad;
    }

    private void writeFile(){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"))){
            if (col == 0) finalNum = 0;
            bufferedWriter.write(Integer.toString(finalNum));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
