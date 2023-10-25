package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OperatorStringSpec : StringSpec({

    "의도한 + 연산자를 가져오는지 테스트" {
        Operator.getOperator("+") shouldBe Operator.PLUS
    }

    "의도한 - 연산자를 가져오는지 테스트" {
        Operator.getOperator("-") shouldBe Operator.MINUS
    }

    "의도한 * 연산자를 가져오는지 테스트" {
        Operator.getOperator("*") shouldBe Operator.MULTIPLY
    }

    "의도한 / 연산자를 가져오는지 테스트" {
        Operator.getOperator("/") shouldBe Operator.DIVIDE
    }

    "연산자가 아닌 경우 테스트" {
        shouldThrow<IllegalArgumentException> {
            Operator.getOperator("&")
        }
    }
})
