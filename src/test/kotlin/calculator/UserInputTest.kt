package calculator

import calculator.ui.InputStrategy
import calculator.ui.UserInput
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource

internal class UserInputTest {

    @ParameterizedTest
    @NullAndEmptySource
    fun `null 입력시 예외 발생`(input: String?) {
        assertThatThrownBy {
            UserInput(object : InputStrategy {
                override fun enter(): String? {
                    return input
                }
            }).operate()
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
