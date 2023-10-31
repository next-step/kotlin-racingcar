package week1.racingcar

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class InputViewTest {
    @ParameterizedTest
    @MethodSource
    fun `이름이 올바르지 않은 경주`(inputString: InputView.InputString) {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            InputView().getValidateRaceInfo(inputString)
        }
    }

    @ParameterizedTest
    @MethodSource
    fun `횟수가 올바르지 않은 경주`(inputString: InputView.InputString) {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            InputView().getValidateRaceInfo(inputString)
        }
    }

    companion object {
        @JvmStatic
        fun `이름이 올바르지 않은 경주`() = listOf(
            Arguments.of(InputView.InputString(" ", "6")),
            Arguments.of(InputView.InputString("", "6")),
            Arguments.of(InputView.InputString("a,b,abcdef", "5")),
            Arguments.of(InputView.InputString("asdfasdf", "4")),
        )

        @JvmStatic
        fun `횟수가 올바르지 않은 경주`() = listOf(
            Arguments.of(InputView.InputString("a,b,c,d", "a")),
            Arguments.of(InputView.InputString("a,b,c,d", " ")),
            Arguments.of(InputView.InputString("a,b,c,d", null)),
        )
    }
}
