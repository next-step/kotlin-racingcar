package racingcar.game.vo

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import racingcar.game.ui.InputConsole
import java.util.stream.Stream

internal class InputConsoleTest {

    private lateinit var carNameReader: () -> String?
    private lateinit var numOfGameReader: () -> String?

    @ParameterizedTest
    @CsvSource("@", "a")
    fun `numOfGame 입력 파라미터는 모두 정수이어야 한다`(numOfGame: String) {
        assertThrows<IllegalArgumentException> {
            carNameReader = { "test" }
            numOfGameReader = { numOfGame }
            InputConsole(carNameReader, numOfGameReader).run()
        }
    }

    @ParameterizedTest
    @CsvSource("-1", "0")
    fun `numOfGame 입력 파라미터는 모두 1 이상이어야 한다`(numOfGame: String) {
        assertThrows<java.lang.IllegalArgumentException> {
            carNameReader = { "test" }
            numOfGameReader = { numOfGame }
            InputConsole(carNameReader, numOfGameReader).run()
        }
    }

    @ParameterizedTest
    @MethodSource("provideStringForIsBlank")
    fun `모든 입력 파라미터는 모두 not null, not blank이어야 한다`(numOfCar: String?, numOfGame: String?) {
        assertThrows<java.lang.IllegalArgumentException> {
            carNameReader = { numOfCar }
            numOfGameReader = { numOfGame }
            InputConsole(carNameReader, numOfGameReader).run()
        }
    }

    @ParameterizedTest
    @CsvSource("asdfqwer", "a,b,asdfgh", delimiter = ';')
    fun `자동차 이름 파라미터는 5자를 초과할 수 없다`(nameOfCar: String) {
        assertThrows<java.lang.IllegalArgumentException> {
            carNameReader = { nameOfCar }
            numOfGameReader = { "1" }
            InputConsole(carNameReader, numOfGameReader).run()
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
