package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldStartWith

internal class CalculatorTest : AnnotationSpec() {

    @Test
    fun `계산`() {
        // given
        val calculator = Calculator()
        listOf(
            "2 + 3 * 4 / 2" to 10,
            "10 * 2 - 3 / 1" to 17,

            // when
            // then
        ).forAll { (expression, expected) -> calculator.calculate(expression) shouldBe expected }
    }

    @Test
    fun `빈 문자열 예외`() {
        val exception = shouldThrow<IllegalArgumentException> {
            Calculator().calculate("")
        }
        println(exception)
        exception.message shouldStartWith "잘못된"
    }

    @Test
    fun `null 예외`() {
        val exception = shouldThrow<IllegalArgumentException> {
            Calculator().calculate(null)
        }
        println(exception)
        exception.message shouldStartWith "잘못된"
    }
}