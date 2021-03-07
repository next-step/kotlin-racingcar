package racingcar.ui

import input.InputStrategy
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource

internal class InputViewTest {
    @ParameterizedTest
    @NullSource
    fun `null 입력시 예외 발생`(input: String?) {
        Assertions.assertThatThrownBy {
            InputView(
                "",
                object : InputStrategy {
                    override fun enter(): String? {
                        return input
                    }
                }
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
