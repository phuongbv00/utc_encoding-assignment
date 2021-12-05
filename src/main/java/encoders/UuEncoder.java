package encoders;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UuEncoder extends Encoder {
    private final List<String> ENCODING_MATRIX = Arrays.asList(
            "`", "!", "\"", "#", "$", "%", "&", "'",
            "(", ")", "*", "+", ",", "-", ".", "/",
            "0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", ":", ";", "<", "=", ">", "?",
            "@", "A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T", "U", "V", "W",
            "X", "Y", "Z", "[", "\\", "]", "^", "_"
    );

    @Override
    Map<Integer, String> getEncodingTable() {
        var n = ENCODING_MATRIX.size();
        return IntStream.range(0, n).boxed().collect(Collectors.toMap(i -> i, ENCODING_MATRIX::get));
    }

    @Override
    String getEmptyDataSymbol() {
        return "`";
    }

    public static void main(String[] args) {
        System.out.println("KQ: " + new UuEncoder().encode("Thi"));
    }
}
