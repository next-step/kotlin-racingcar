package racingcar.ui

import input.InputStrategy
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class IntegerInputParserTest {

    @ParameterizedTest
    @ValueSource(strings = ["0", "-1", Int.MIN_VALUE.toString()])
    fun `최소 요구값(1) 미만 시 예외 발생`(input: String) {
        Assertions.assertThatThrownBy {
            IntegerInputParser().parse(
                InputView(
                    "",
                    object : InputStrategy {
                        override fun enter(): String {
                            return input
                        }
                    }
                ).value
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["ㅁ", "가나", "~"])
    fun `문자열이 정수가 아닐 시 예외 발생`(input: String) {
        Assertions.assertThatThrownBy {
            IntegerInputParser().parse(
                InputView(
                    "",
                    object : InputStrategy {
                        override fun enter(): String {
                            return input
                        }
                    }
                ).value
            )
        }.isInstanceOf(NumberFormatException::class.java)
    }
}
