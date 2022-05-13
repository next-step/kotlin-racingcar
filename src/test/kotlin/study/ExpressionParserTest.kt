package study

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class ExpressionParserTest : AnnotationSpec() {

    @Test
    fun `짝수개의 피연산자가 포함된 식을 계산한 결괏값 검증`() {
        // given
        val expr = "1 + 2"

        // when
        val result = ExpressionParser.compile(expr).calculate()

        // then
        result shouldBe Operand(3)
    }

    @Test
    fun `홀수개의 피연산자가 포함된 식을 계산한 결괏값 검증`() {
        // given
        val expr = "1 + 2 + 1"

        // when
        val result = ExpressionParser.compile(expr).calculate()

        // then
        result shouldBe Operand(4)
    }

    @Test
    fun `사칙연산 연산자가 포함된 식을 계산한 결괏값 검증`() {
        // given
        val expr = "1 * 2 + 1 - 1 / 2"

        // when
        val result = ExpressionParser.compile(expr).calculate()

        // then
        result shouldBe Operand(1)
    }

    @Test
    fun `지원하지 않는 연산자가 포함된 경우 IllegalArgumentException 예외 처리`() {
        // given
        val expr = "1 * 2 + 1 - 1 / 2 % 10"

        // when
        val throwableAction = {
            ExpressionParser.compile(expr)
        }

        // then
        shouldThrow<IllegalArgumentException>(throwableAction)
    }

    @Test
    fun `피연산자가 부족한 식의 경우 IllegalArgumentException 예외 처리`() {
        // given
        val expr = "1 * 2 + 1 - 1 / 2 %"

        // when
        val throwableAction = {
            ExpressionParser.compile(expr)
        }

        // then
        shouldThrow<IllegalArgumentException>(throwableAction)
    }

    @Test
    fun `연산자가 부족한 식의 경우 IllegalArgumentException 예외 처리`() {
        // given
        val expr = "1 * 2 + 1 - 1 / 2 10"

        // when
        val throwableAction = {
            ExpressionParser.compile(expr)
        }

        // then
        shouldThrow<IllegalArgumentException>(throwableAction)
    }

    @Test
    fun `식에 문자가 포함된 경우 IllegalArgumentException 예외 처리`() {
        // given
        val expr = "2 x 10"

        // when
        val throwableAction = {
            ExpressionParser.compile(expr)
        }

        // then
        shouldThrow<IllegalArgumentException>(throwableAction)
    }
}
