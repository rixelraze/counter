import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.print("Введите путь к файлу с текстом: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        getWordCount(fileName);
    }

    public static void getWordCount(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner;
        scanner = new Scanner(file);
        int words = 0;
        while (scanner.hasNextLine()) {
            String[] array = scanner.nextLine().split(" ");
            words = words + array.length;
        }
        System.out.println("Количество слов: " + words);
        scanner.close();

        int charCount;
        int withoutSpaces;

        try (Scanner scanner1 = new Scanner(Paths.get("input"), StandardCharsets.UTF_8)) {
            String str = scanner1.useDelimiter("\\A").next();
            charCount = str.length();
            System.out.println("Количество символов: " + charCount);

            int spaces = str.length() - str.replace(" ", "").length();
            withoutSpaces = charCount - spaces;
            System.out.println("Количество символов без пробелов: " + withoutSpaces);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File file2 = new File("output");
        PrintWriter printWriter = new PrintWriter(file2);
        printWriter.println("Количество слов:" + words);
        printWriter.println("Количество символов:" + charCount);
        printWriter.println("Количество символов без пробелов:" + withoutSpaces);
        printWriter.close();
    }
}