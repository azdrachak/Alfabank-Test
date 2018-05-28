import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ParseAndPrint {
    public static void main(String[] args) throws IOException {
        String path = "task1\\src\\testfile1.txt";
        String data = new String(Files.readAllBytes(Paths.get(path)));

        List<Integer> numbers = Arrays.stream(data.split(",")).map(Integer::valueOf).collect(Collectors.toList());

        List<Integer> ascNumbers = numbers.stream().sorted(Comparator.comparing(Integer::valueOf)).collect(Collectors.toList());
        System.out.println(ascNumbers);

        List<Integer> descNumbers = numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(descNumbers);
    }
}
