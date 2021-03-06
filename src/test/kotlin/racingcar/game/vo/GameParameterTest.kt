package racingcar.game.vo

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class GameParameterTest {
    @ParameterizedTest
    @CsvSource("a,1", "1,a", "a,a")
    fun `입력 파라미터는 모두 정수이어야 한다`(numOfCar: String, numOfGame: String) {
        assertThrows<IllegalArgumentException> {
            GameParameter(numOfCar, numOfGame)
        }
    }

    @ParameterizedTest
    @CsvSource("0,1", "1,0", "0,0")
    fun `입력 파라미터는 모두 1 이상이어야 한다`(numOfCar: String, numOfGame: String) {
        assertThrows<java.lang.IllegalArgumentException> {
            GameParameter(numOfCar, numOfGame)
        }
    }

    @ParameterizedTest
    @MethodSource("provideStringForIsBlank")
    fun `입력 파라미터는 모두 not null, not blank이어야 한다`(numOfCar: String?, numOfGame: String?) {
        assertThrows<java.lang.IllegalArgumentException> {
            GameParameter(numOfCar, numOfGame)
        }
    }

    companion object {
        @JvmStatic
        fun provideStringForIsBlank(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(null, null),
                Arguments.of("", ""),
                Arguments.of(" ", " "),
                Arguments.of(null, ""),
                Arguments.of(null, " "),
                Arguments.of("", null),
                Arguments.of("", " "),
                Arguments.of(" ", null),
                Arguments.of(" ", ""),
            )
        }
    }
}
