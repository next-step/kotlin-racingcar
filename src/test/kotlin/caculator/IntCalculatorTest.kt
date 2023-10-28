package caculator

import calculator.IntCalculator
import calculator.IntExpression
import calculator.Operator
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class IntCalculatorTest : StringSpec({
    "연산이 순차적으로 계산된다" {
        val expression = IntExpression(
            initialNumber = 1,
            operations = listOf(
                IntExpression.Operation(Operator.ADD, 7),
                IntExpression.Operation(Operator.SUBTRACT, 2),
                IntExpression.Operation(Operator.DIVIDE, 5),
                IntExpression.Operation(Operator.MULTIPLY, 10)
            )
        )

        val result = IntCalculator.calculate(expression)

        result shouldBe 10
    }

    "연산이 없는 식인 경우 초기값이 반환된다" {
        val expression = IntExpression(
            initialNumber = 1,
            operations = emptyList()
        )

        val result = IntCalculator.calculate(expression)

        result shouldBe expression.initialNumber
    }

    "덧셈이 계산된다" {
        val expression = IntExpression(
            initialNumber = 1,
            operations = listOf(IntExpression.Operation(Operator.ADD, 5))
        )

        val result = IntCalculator.calculate(expression)

        result shouldBe 6
    }

    "뺄셈이 계산된다" {
        val expression = IntExpression(
            initialNumber = 5,
            operations = listOf(IntExpression.Operation(Operator.SUBTRACT, 10))
        )

        val result = IntCalculator.calculate(expression)

        result shouldBe -5
    }

    "곱셈이 계산된다" {
        val expression = IntExpression(
            initialNumber = 5,
            operations = listOf(IntExpression.Operation(Operator.MULTIPLY, 4))
        )

        val result = IntCalculator.calculate(expression)

        result shouldBe 20
    }

    "나눗셈이 계산된다" {
        val expression = IntExpression(
            initialNumber = 10,
            operations = listOf(IntExpression.Operation(Operator.DIVIDE, 5))
        )

        val result = IntCalculator.calculate(expression)

        result shouldBe 2
    }

    "나눗셈을 계산할 때 나머지는 버림 처리된다" {
        val expression = IntExpression(
            initialNumber = 8,
            operations = listOf(IntExpression.Operation(Operator.DIVIDE, 3))
        )

        val result = IntCalculator.calculate(expression)

        result shouldBe 2
    }

    "0으로 나눌 경우 에러가 발생한다" {
        shouldThrowExactly<IllegalArgumentException> {
            val expression = IntExpression(
                initialNumber = 8,
                operations = listOf(IntExpression.Operation(Operator.DIVIDE, 0))
            )
            IntCalculator.calculate(expression)
        }
    }
})
