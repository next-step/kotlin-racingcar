package calculator.util

import calculator.Operator
import calculator.Operators
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import io.kotest.matchers.shouldBe

internal class ExpressionSeparatorTest : StringSpec({
    "주어진 수식을 피연산자와 연산자로 나눈다" {
        // given
        val expression = "2 + 3 * 4 / 2"

        // when
        val actual = ExpressionSeparator.separate(expression)

        // then
        actual.first shouldBe listOf(2, 3, 4, 2)
        actual.second shouldBeEqualToComparingFields Operators(
            listOf(
                Operator.PLUS,
                Operator.MULTIPLY,
                Operator.DIVIDE
            )
        )
    }

    "연산자가 잘못된 수식을 피연산자와 연산자로 나누면 예외를 발생시킨다" {
        // given
        val expression = "2 ( 3 * 4 / 2"

        // when // then
        shouldThrowExactly<IllegalArgumentException> { ExpressionSeparator.separate(expression) }
    }

    "피연산자가 잘못된 수식을 피연산자와 연산자로 나누면 예외를 발생시킨다" {
        // given
        val expression = "x + 3 * 4 / 2"

        // when // then
        shouldThrowExactly<NumberFormatException> { ExpressionSeparator.separate(expression) }
    }
})
