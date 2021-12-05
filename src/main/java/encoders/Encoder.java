package encoders;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Encoder {
    abstract Map<Integer, String> getEncodingTable();

    abstract String getEmptyDataSymbol();

    public String encode(String value) {
        var ENCODING_TABLE = getEncodingTable();
        var missing = new AtomicInteger(0);
        return Arrays.stream(Arrays.stream(value.split(""))
                        .peek(System.out::print)
                        .peek(__ -> System.out.print(" -> "))
                        .map(s -> (int) s.charAt(0))
                        .peek(System.out::print)
                        .peek(__ -> System.out.print(" -> "))
                        .map(Integer::toBinaryString)
                        .map(s -> String.format("%8s", s).replace(' ', '0'))
                        .peek(System.out::println)
                        .collect(Collectors.joining())
                        .split("(?<=\\G.{6})"))
                .peek(s -> missing.set(6 - s.length()))
                .map(s -> String.format("%-6s", s).replace(' ', '0'))
                .peek(System.out::print)
                .map(s -> Integer.parseInt(s, 2))
                .peek(__ -> System.out.print(" -> "))
                .peek(System.out::print)
                .peek(__ -> System.out.print(" -> "))
                .map(ENCODING_TABLE::get)
                .peek(System.out::println)
                .collect(Collectors.joining()) + IntStream.range(0, missing.get() / 2).mapToObj(__ -> getEmptyDataSymbol()).collect(Collectors.joining());
    }
}
