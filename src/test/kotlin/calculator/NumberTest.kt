package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class NumberTest : StringSpec({
    "객체를 생성할 때 '1a'와 같이 숫자로 변환할 수 없는 값이면 예외가 발생한다." {
        // when then
        val exception = shouldThrow<IllegalArgumentException> { Operand.of("1a") }
        exception.message shouldBe "연산할 수 없는 문자열 입니다. value: 1a"
    }

    "plus 함수를 호출하여 Number 객체의 값을 더할 수 있다." {
        // given
        val operand1 = Operand.of("1")
        val operand2 = Operand.of("2")

        // when
        val result = operand1.plus(operand2)

        // then
        result shouldBe Operand.of("3")
    }

    "minus 함수를 호출하여 Number 객체의 값을 뺄 수 있다." {
        // given
        val operand1 = Operand.of("1")
        val operand2 = Operand.of("2")

        // when
        val result = operand1.minus(operand2)

        // then
        result shouldBe Operand.of("-1")
    }

    "multiple 함수를 호출하여 Number 객체의 값을 곱할 수 있다." {
        // given
        val operand1 = Operand.of("2")
        val operand2 = Operand.of("3")

        // when
        val result = operand1.multiply(operand2)

        // then
        result shouldBe Operand.of("6")
    }

    "divide 함수를 호출하여 Number 객체의 값을 나눌 수 있다." {
        // given
        val operand1 = Operand.of("6")
        val operand2 = Operand.of("2")

        // when
        val result = operand1.divide(operand2)

        // then
        result shouldBe Operand.of("3")
    }
})
