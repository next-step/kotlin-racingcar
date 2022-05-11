package calculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class OperatorTest : FreeSpec({

    "문자열로 덧셈 연산자를 찾을 수 있다." - {
        // when
        val operator = Operator.findBySign(sign = "+")

        // then
        operator shouldBe Operator.ADDITION
    }

    "문자열로 뺄셈 연산자를 찾을 수 있다." - {
        // when
        val operator = Operator.findBySign(sign = "-")

        // then
        operator shouldBe Operator.SUBTRACTION
    }

    "문자열로 곱셈 연산자를 찾을 수 있다." - {
        // when
        val operator = Operator.findBySign(sign = "*")

        // then
        operator shouldBe Operator.MULTIPLICATION
    }

    "문자열로 나눗셈 연산자를 찾을 수 있다." - {
        // when
        val operator = Operator.findBySign(sign = "/")

        // then
        operator shouldBe Operator.DIVISION
    }

    "문자열에 해당되는 연산자가 없는 경우 예외가 발생한다." - {
        // when
        val exception = shouldThrowExactly<IllegalArgumentException> { Operator.findBySign(sign = "#") }

        // then
        exception.message shouldBe "# 에 해당하는 연산자를 찾지 못했습니다."
    }
})
