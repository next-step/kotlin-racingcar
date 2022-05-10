package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class ExpressionTest : StringSpec({

    "숫자의 개수가 `연산자(Operator)`의 개수보다 1만큼 큰 수식을 생성할 수 있다" {
        val numbers = listOf(2, 4, 5, 6)
        val operators = listOf(Operator.ADDITION, Operator.SUBTRACTION, Operator.DIVISION)

        Expression(numbers, operators) shouldNotBe null
    }

    "숫자의 개수가 `연산자(Operator)`의 개수보다 1만큼 크지 않은 경우 예외를 발생한다" {
        val numbers = listOf(2, 4, 5, 6)
        val operators = listOf(Operator.ADDITION, Operator.SUBTRACTION)

        shouldThrow<IllegalArgumentException> {
            Expression(numbers, operators)
        }
    }

    "문자열을 입력 받아 `수식(Expression)`을 생성할 수 있다" {
        listOf(
            "2 + 3",
            "2 + 3 * 4",
            "2 + 3 * 4 / 2",
            "2 + 3 * 4 / 2 - 10"
        ).forAll { expressionText ->
            Expression.of(expressionText) shouldNotBe null
        }
    }

    "문자열의 숫자가 `수식(Expression)`의 숫자와 연산자로 구성된다" {
        listOf(
            listOf(2, 3) to listOf(
                Operator.ADDITION
            ) to "2 + 3",
            listOf(2, 3, 4) to listOf(
                Operator.ADDITION,
                Operator.MULTIPLICATION
            ) to "2 + 3 * 4",
            listOf(2, 3, 4, 2) to listOf(
                Operator.ADDITION,
                Operator.MULTIPLICATION,
                Operator.DIVISION
            ) to "2 + 3 * 4 / 2",
            listOf(2, 3, 4, 2, 10) to listOf(
                Operator.ADDITION,
                Operator.MULTIPLICATION,
                Operator.DIVISION,
                Operator.SUBTRACTION
            ) to "2 + 3 * 4 / 2 - 10"
        ).forAll { (numbersAndOperators, expressionText) ->
            Expression.of(expressionText) shouldBe Expression(numbersAndOperators.first, numbersAndOperators.second)
        }
    }

    "올바르지 않은 수식의 문자열 입력 시 예외가 발생한다." {
        listOf(
            "2 + 3 /",
            "2+* 4",
            "2 . 3",
            "",
            "   "
        ).forAll {
            shouldThrow<IllegalArgumentException> {
                Expression.of(it)
            }
        }
    }
})
