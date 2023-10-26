package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe

class OperatorTest : ExpectSpec({

    expect("연산자 문자열을 입력하면 연산자 객체를 반환한다.") {
        Operator.from("+") shouldBe Operator.PLUS
        Operator.from("-") shouldBe Operator.MINUS
        Operator.from("*") shouldBe Operator.MULTIPLY
        Operator.from("/") shouldBe Operator.DIVIDE
    }

    expect("연산자 문자열이 아니면 예외가 발생한다.") {
        shouldThrow<IllegalArgumentException> {
            Operator.from("a")
        }
    }

    expect("나눗셈 연산자의 두번째 피연산자가 0이면 예외가 발생한다.") {
        shouldThrow<IllegalArgumentException> {
            Operator.DIVIDE.getResult(10, 0)
        }
    }
})
