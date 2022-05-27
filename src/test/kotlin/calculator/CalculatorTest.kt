package calculator

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource

internal class CalculatorTest() : AnnotationSpec() {

    @Test
    fun calculate() {
        Calculator.calculate("2 + 3 * 4 / 2") shouldBe 10
    }

    @Test
    fun `연산 불가능한 피연산자가 입력된 경우 예외 처리`() {
        val nonArithmeticOperand = "X"
        assertThrows<IllegalArgumentException> { Calculator.calculate("2 + $nonArithmeticOperand") }
            .message shouldBe "연산 불가능한 피연산자가 입력되었습니다.: $nonArithmeticOperand"
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 및 null 이 입력된 경우 예외 처리`(emptyString: String?) {
        assertThrows<IllegalArgumentException> { Calculator.calculate(emptyString) }
            .message shouldBe "연산 불가능한 입력 입니다."
    }
}
