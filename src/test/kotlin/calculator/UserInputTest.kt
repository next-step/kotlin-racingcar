package calculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserInputTest {

    @Test
    fun `성공 - 올바른 계산식 입력`() {

        val userInput = UserInput("2 + 3 * 4 / 2")
        userInput.validate()

        assertThat(userInput.inputString).isEqualTo("2 + 3 * 4 / 2")
    }

    @Test
    fun `실패 - 계산식 공백, null, whitespace 입력`() {

        val blankInput = UserInput("")
        Assertions.assertThatThrownBy { blankInput.validate() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("계산식이 비어있습니다")

        val nullInput = UserInput(null)
        Assertions.assertThatThrownBy { nullInput.validate() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("계산식이 비어있습니다")

        val whitespaceInput = UserInput("   ")
        Assertions.assertThatThrownBy { whitespaceInput.validate() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("계산식이 비어있습니다")
    }

    @Test
    fun `실패 - 계산식 숫자나 사칙연산 수식 이외 값 입력`() {

        val inputNotNumber = UserInput("1 + 일 * 이")
        Assertions.assertThatThrownBy { inputNotNumber.validate() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("계산식에 숫자와 사칙연산 기호 이외의 값이 포함되어 있습니다")

        val inputNotOperator = UserInput("1 + 2 = 3")
        Assertions.assertThatThrownBy { inputNotOperator.validate() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("계산식에 숫자와 사칙연산 기호 이외의 값이 포함되어 있습니다")
    }
}
