package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OperatorTest : StringSpec({
    "연산자 정상 확인" {
        Operator.find("+") shouldBe Operator.PLUS
        Operator.find("-") shouldBe Operator.MINUS
        Operator.find("/") shouldBe Operator.DIVISION
        Operator.find("*") shouldBe Operator.MULTIPLE
    }

    "연산자 비정상 확인" {
        shouldThrow<IllegalArgumentException> {
            Operator.find("&")
        }
    }
})
