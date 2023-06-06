package next.step.calculator.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import next.step.calculator.domain.exception.NotEnoughExpressionCountException
import org.junit.jupiter.api.Test

class ExpressionsTest {
    @Test
    fun `expression list에 대해 계산`() {
        Expressions.of(listOf("2", "+", "3", "*", "4", "/", "2")).evaluate() shouldBe 10
    }

    @Test
    fun `expression 개수가 모자라면 예외 발생`() {
        shouldThrow<NotEnoughExpressionCountException> {
            Expressions.of(listOf("2", "+", "3", "*", "4", "/"))
        }
    }
}
