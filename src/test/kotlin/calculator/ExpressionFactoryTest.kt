package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class ExpressionFactoryTest : StringSpec({
    val expressionFactory = ExpressionFactory(
        object : SeparationStrategy {
            override fun separate(input: String): List<String> {
                return input.split(" ")
            }
        }
    )

    "문자열을 입력 받아 `수식(Expression)`을 생성할 수 있다" {
        listOf(
            "2 + 3",
            "2 + 3 * 4",
            "2 + 3 * 4 / 2",
            "2 + 3 * 4 / 2 - 10"
        ).forAll { expressionText ->
            expressionFactory.create(expressionText) shouldNotBe null
        }
    }

    "문자열의 숫자가 `수식(Expression)`의 숫자로 구성된다" {
        listOf(
            "2 + 3" to listOf(2, 3),
            "2 + 3 * 4" to listOf(2, 3, 4),
            "2 + 3 * 4 / 2" to listOf(2, 3, 4, 2),
            "2 + 3 * 4 / 2 - 10" to listOf(2, 3, 4, 2, 10)
        ).forAll { (expressionText, numbers) ->
            val expression = expressionFactory.create(expressionText)
            expression.numbers shouldBe numbers
        }
    }

    "문자열의 연산자 기호가 `수식(Expression)`의 연산자로 구성된다" {
        listOf(
            "2 + 3" to listOf(
                Operator.ADDITION
            ),
            "2 + 3 * 4" to listOf(
                Operator.ADDITION,
                Operator.MULTIPLICATION
            ),
            "2 + 3 * 4 / 2" to listOf(
                Operator.ADDITION,
                Operator.MULTIPLICATION,
                Operator.DIVISION
            ),
            "2 + 3 * 4 / 2 - 10" to listOf(
                Operator.ADDITION,
                Operator.MULTIPLICATION,
                Operator.DIVISION,
                Operator.SUBTRACTION
            ),
        ).forAll { (expressionText, operators) ->
            val expression = expressionFactory.create(expressionText)
            expression.operators shouldBe operators
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
                expressionFactory.create(it)
            }
        }
    }
})
