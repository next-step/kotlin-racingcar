package calculator.ui

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class ViewKtTest {

    @Test
    @DisplayName("inputExpression 함수를 이용해 사용자 입력을 받을 수 있다")
    fun inputExpressionTest() {
        val inputExpression = "1 + 3"
        val expression = inputExpression(inputExpression.byteInputStream())
        assertThat(inputExpression).isEqualTo(expression)
    }
}
