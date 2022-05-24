package calculator

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource

internal class CalculatorTest() : AnnotationSpec() {

    @Test
    fun calculate() {
        Calculator.calculate("2 + 3 * 4 / 2") shouldBe 10
    }

    @Test
    fun `덧셈`() {
        Calculator.calculate("2 + 3") shouldBe 5
    }

    @Test
    fun `뺄셈`() {
        Calculator.calculate("2 - 3") shouldBe -1
    }

    @Test
    fun `곱셈`() {
        Calculator.calculate("2 * 3") shouldBe 6
    }

    @Test
    fun `나눗셈`() {
        Calculator.calculate("5 / 2") shouldBe 2.5
    }

    @Test
    fun `나눗셈 시 우항 피연산자가 0 일 경우 예외 처리`() {
        assertThrows<IllegalStateException> { Calculator.calculate("5 / 0") }
            .message shouldBe "0 으로 나눌 수 없습니다."
    }

    @Test
    fun `연산 불가능한 연산자가 입력된 경우 예외 처리`() {
        val nonArithmeticOperator = "//"
        assertThrows<IllegalArgumentException> { Calculator.calculate("5 $nonArithmeticOperator 2") }
            .message shouldBe "연산 불가능한 연산자가 입력되었습니다.: $nonArithmeticOperator"
    }

    @Test
    fun `연산 불가능한 피연산자가 입력된 경우 예외 처리`() {
        val nonArithmeticOperand = "X"
        assertThrows<IllegalArgumentException> { Calculator.calculate("2 + $nonArithmeticOperand") }
            .message shouldBe "연산 불가능한 피연산자가 입력되었습니다.: $nonArithmeticOperand"
    }

    @ParameterizedTest
    @EmptySource
    fun `빈 문자열이 입력된 경우 예외 처리`(emptyString: String) {
        assertThrows<IllegalArgumentException> { Calculator.calculate(emptyString) }
            .message shouldBe "연산 불가능한 문자열이 입력되었습니다."
    }
}
