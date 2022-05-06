package study

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class CalcParserTest : AnnotationSpec() {

    @Test
    fun `짝수개의 피연산자가 포함된 식을 계산할 경우 결과 반환`() {
        // given
        val expr = "1 + 2"

        // when
        val result = CalcParser.parse(expr).calculate()

        // then
        result shouldBe Operand(3)
    }

    @Test
    fun `홀수개의 피연산자가 포함된 식을 계산할 경우 결과 반환`() {
        // given
        val expr = "1 + 2 + 1"

        // when
        val result = CalcParser.parse(expr).calculate()

        // then
        result shouldBe Operand(4)
    }

    @Test
    fun `다양한 연산자가 포함된 식을 계산할 경우 결과 반환`() {
        // given
        val expr = "1 * 2 + 1 - 1 / 2"

        // when
        val result = CalcParser.parse(expr).calculate()

        // then
        result shouldBe Operand(1)
    }

    @Test
    fun `지원하지 않는 연산자가 포함된 경우 예외 발생`() {
        // given
        val expr = "1 * 2 + 1 - 1 / 2 % 10"

        // when

        // then
        shouldThrow<IllegalArgumentException> {
            CalcParser.parse(expr)
        }
    }

    @Test
    fun `피연산자가 부족한 식의 경우 예외 발생`() {
        // given
        val expr = "1 * 2 + 1 - 1 / 2 %"

        // when

        // then
        shouldThrow<IllegalArgumentException> {
            CalcParser.parse(expr)
        }
    }

    @Test
    fun `연산자가 부족한 식의 경우 예외 발생`() {
        // given
        val expr = "1 * 2 + 1 - 1 / 2 10"

        // when

        // then
        shouldThrow<IllegalArgumentException> {
            CalcParser.parse(expr)
        }
    }

    @Test
    fun `문자가 포함된 경우 예외 발생`() {
        // given
        val expr = "2 x 10"

        // when

        // then
        shouldThrow<IllegalArgumentException> {
            CalcParser.parse(expr)
        }
    }

    @Test
    fun `빈 공백의 식을 분석할 경우 예외 발생`() {
        // given
        val expr = " "

        // when

        // then
        shouldThrow<IllegalArgumentException> {
            CalcParser.parse(expr)
        }
    }
}
