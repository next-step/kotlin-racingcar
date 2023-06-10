package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class OperatorTest : StringSpec({
    "두 수에 대해 Operator.ADD가 올바른 연산 결과를 반환한다" {
        Operator.ADD.execute(5, 3) shouldBe 8
    }

    "두 수에 대해 Operator.SUBTRACT가 올바른 연산 결과를 반환한다" {
        Operator.SUBTRACT.execute(5, 3) shouldBe 2
    }

    "두 수에 대해 Operator.MULTIPLY가 올바른 연산 결과를 반환한다" {
        Operator.MULTIPLY.execute(9, 3) shouldBe 27
    }

    "두 수에 대해 Operator.DIVIDE가 올바른 연산 결과를 반환한다" {
        Operator.DIVIDE.execute(9, 3) shouldBe 3
    }

    "나누려는 수가 0인 경우 Operator.DIVIDE가 에러를 throw 한다" {
        shouldThrow<IllegalArgumentException> {
            Operator.DIVIDE.execute(5, 0)
        }
    }
})
