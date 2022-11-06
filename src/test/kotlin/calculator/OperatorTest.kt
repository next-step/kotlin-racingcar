package calculator

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import java.lang.ArithmeticException
import java.lang.IllegalArgumentException

class OperatorTest : StringSpec({

    "지원하지 않은 연산자인 경우 IllegalArgumentException 이 발생해요." {
        listOf(
            "(",
            ")",
            "^",
            "%"
        ).forAll { operator ->
            shouldThrow<IllegalArgumentException> {
                Operator.findByStringOperator(operator)
            }
        }
    }

    "지원하는 연산자인 경우 해당하는 연산자 enum을 반환해요" {
        listOf(
            "+",
            "-",
            "*",
            "/"
        ).forAll { operator ->
            shouldNotThrow<IllegalArgumentException> {
                Operator.findByStringOperator(operator)
            }
        }
    }

    "PLUS enum 의 경우 두개의 값을 더해요" {
        val operator = Operator.PLUS
        operator.execute(1, 2) shouldBe 3
    }

    "MINUS enum 의 경우 두개의 값을 더해요" {
        val operator = Operator.MINUS
        operator.execute(2, 1) shouldBe 1
    }

    "MULTIPLY enum 의 경우 두개의 값을 곱해요" {
        val operator = Operator.MULTIPLY
        operator.execute(2, 1) shouldBe 2
    }

    "DIVIDE enum 의 경우 두개의 값을 나눠요" {
        val operator = Operator.DIVIDE
        operator.execute(2, 1) shouldBe 2
    }

    "DIVIDE enum 의 경우 0으로 값을 나누면 ArithmeticException 이 발생해요." {
        shouldThrow<ArithmeticException> {
            val operator = Operator.DIVIDE
            operator.execute(1, 0)
        }
    }
})
