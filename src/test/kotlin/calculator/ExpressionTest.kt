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
})
