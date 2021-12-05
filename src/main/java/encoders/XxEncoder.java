package encoders;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class XxEncoder extends Encoder {
    @Override
    Map<Integer, String> getEncodingTable() {
        String encodingMatrixRaw = "+ - 0 1 2 3 4 5 " +
                "6 7 8 9 A B C D " +
                "E F G H I J K L " +
                "M N O P Q R S T " +
                "U V W X Y Z a b " +
                "c d e f g h i j " +
                "k l m n o p q r " +
                "s t u v w x y z";
        var encodingMatrix = Arrays.asList(encodingMatrixRaw.split(" "));
        var n = encodingMatrix.size();
        return IntStream.range(0, n).boxed().collect(Collectors.toMap(i -> i, encodingMatrix::get));
    }

    @Override
    String getEmptyDataSymbol() {
        return "+";
    }

    public static void main(String[] args) {
        System.out.println("KQ: " + new XxEncoder().encode("Thi"));
    }
}
