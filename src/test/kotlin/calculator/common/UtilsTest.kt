package calculator.common

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class UtilsTest {

    private val utils = Utils()

    @Test
    @DisplayName("숫자 string이 아니면 false를 반환한다")
    fun isNumericFalse() {
        Assertions.assertThat(utils.isNumeric("1 - 2")).isEqualTo(false)
        Assertions.assertThat(utils.isNumeric("11111111&")).isEqualTo(false)
        Assertions.assertThat(utils.isNumeric("gs@!")).isEqualTo(false)
    }

    @Test
    @DisplayName("숫자 string이면 true를 반환한다")
    fun isNumericTrue() {
        Assertions.assertThat(utils.isNumeric("12345")).isEqualTo(true)
        Assertions.assertThat(utils.isNumeric("11111111")).isEqualTo(true)
        Assertions.assertThat(utils.isNumeric("9392348100001")).isEqualTo(true)
    }

    @Test
    @DisplayName("사칙연산자로만 이뤄진 게 아니면 false를 반환한다")
    fun isOperatorFalse() {
        Assertions.assertThat(utils.isOperator("1 - 2")).isEqualTo(false)
        Assertions.assertThat(utils.isOperator("*&!#$!&")).isEqualTo(false)
        Assertions.assertThat(utils.isOperator("+-*/()")).isEqualTo(false)
    }

    @Test
    @DisplayName("사칙연산자로만 이뤄져있으면 true를 반환한다")
    fun isOperatorTrue() {
        Assertions.assertThat(utils.isOperator("+-*/")).isEqualTo(true)
        Assertions.assertThat(utils.isOperator("+-*/+-*/+-*/")).isEqualTo(true)
        Assertions.assertThat(utils.isOperator("+-")).isEqualTo(true)
    }

    @Test
    @DisplayName("중위 표기식을 후위 표기식으로 변경한다")
    fun infixToPostFixSuccess() {
        Assertions.assertThat(utils.infixToPostFix(listOf("1", "+", "2", "*", "3", "/", "4", "-", "2")))
            .isEqualTo(mutableListOf<String>("1", "2", "+", "3", "*", "4", "/", "2", "-"))
    }
}
