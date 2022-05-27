package calculator

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows

internal class OperatorTest : AnnotationSpec() {

    @Test
    fun `덧셈`() {
        Operator.ADDITION.operate(2.0, 3.0) shouldBe 5
    }

    @Test
    fun `뺄셈`() {
        Operator.SUBTRACTION.operate(2.0, 3.0) shouldBe -1
    }

    @Test
    fun `곱셈`() {
        Operator.MULTIPLICATION.operate(2.0, 3.0) shouldBe 6
    }

    @Test
    fun `나눗셈`() {
        Operator.DIVISION.operate(5.0, 2.0) shouldBe 2.5
    }

    @Test
    fun `나눗셈 시 우항 피연산자가 0 일 경우 예외 처리`() {
        assertThrows<IllegalStateException> { Operator.DIVISION.operate(5.0, 0.0) }
            .message shouldBe "0 으로 나눌 수 없습니다."
    }

    @Test
    fun `연산 불가능한 연산자가 입력된 경우 예외 처리`() {
        val nonArithmeticOperator = "//"
        assertThrows<IllegalArgumentException> { Operator.get(nonArithmeticOperator) }
            .message shouldBe "연산 불가능한 연산자가 입력되었습니다.: $nonArithmeticOperator"
    }
}
