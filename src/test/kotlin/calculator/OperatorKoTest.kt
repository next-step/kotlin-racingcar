package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class OperatorTest : StringSpec({
    "정상 연산자 확인" {
        Operator.find("+") shouldBe Operator.PLUS
        Operator.find("-") shouldBe Operator.MINUS
        Operator.find("/") shouldBe Operator.DIVISION
        Operator.find("*") shouldBe Operator.MULTIPLE
    }

    "비정상 연산자 확인" {
        shouldThrow<IllegalArgumentException> {
            Operator.find("&")
        }
    }
})
