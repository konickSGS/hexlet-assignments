package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class AppTest {
    @ParameterizedTest
    @MethodSource("takeAppProvider")
    void testTake(List<Integer> list, int count, List<Integer> answer) {
        // BEGIN
        assertThat(App.take(list, count)).isEqualTo(answer);
        // END
    }

    private static Stream<Arguments> takeAppProvider() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), 0, List.of()),
                Arguments.of(List.of(1, 2, 3), 1, List.of(1)),
                Arguments.of(List.of(1, 2, 3), 2, List.of(1, 2)),
                Arguments.of(List.of(1, 2, 3), 3, List.of(1, 2, 3)),
                Arguments.of(List.of(1, 2, 3), 4, List.of(1, 2, 3)),
                Arguments.of(List.of(), 4, List.of())
        );
    }
}
