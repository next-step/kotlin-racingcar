package racingcar.game.vo

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class GameParameterTest {

    @ParameterizedTest
    @CsvSource("@", "a")
    fun `numOfGame 입력 파라미터는 모두 정수이어야 한다`(numOfGame: String) {
        assertThrows<IllegalArgumentException> {
            val carNameReader = "test"
            GameParameter.initParameter(carNameReader, numOfGame)
        }
    }

    @ParameterizedTest
    @CsvSource("-1", "0")
    fun `numOfGame 입력 파라미터는 모두 1 이상이어야 한다`(numOfGame: String) {
        assertThrows<java.lang.IllegalArgumentException> {
            val carNameReader = "test"
            GameParameter.initParameter(carNameReader, numOfGame)
        }
    }

    @ParameterizedTest
    @MethodSource("provideStringForIsBlank")
    fun `모든 입력 파라미터는 모두 not null, not blank이어야 한다`(nameOfCar: String?, numOfGame: String?) {
        assertThrows<java.lang.IllegalArgumentException> {
            GameParameter.initParameter(nameOfCar, numOfGame)
        }
    }

    @ParameterizedTest
    @CsvSource("asdfqwer", "a,b,asdfgh", delimiter = ';')
    fun `자동차 이름 파라미터는 5자를 초과할 수 없다`(nameOfCar: String) {
        assertThrows<java.lang.IllegalArgumentException> {
            val numOfGame = "1"
            GameParameter.initParameter(nameOfCar, numOfGame)
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
