package encoders;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Encoder {
    abstract Map<Integer, String> getEncodingTable();

    public String encode(String value) {
        var ENCODING_TABLE = getEncodingTable();
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
                .map(s -> String.format("%-6s", s).replace(' ', '0'))
                .peek(System.out::print)
                .map(s -> Integer.parseInt(s, 2))
                .peek(__ -> System.out.print(" -> "))
                .peek(System.out::print)
                .peek(__ -> System.out.print(" -> "))
                .map(ENCODING_TABLE::get)
                .peek(System.out::println)
                .collect(Collectors.joining());
    }
}
