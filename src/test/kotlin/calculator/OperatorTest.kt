package calculator

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

internal class OperatorTest : StringSpec({
    "두 숫자를 더한다" {
        // given
        val firstNumber = 1
        val secondNumber = 2
        val operator = Operator.PLUS

        // when
        val actual = operator.operate(firstNumber, secondNumber)

        // then
        actual shouldBe 3
    }

    "두 숫자를 뺀다" {
        // given
        val firstNumber = 2
        val secondNumber = 1
        val operator = Operator.MINUS

        // when
        val actual = operator.operate(firstNumber, secondNumber)

        // then
        actual shouldBe 1
    }

    "두 숫자를 곱한다" {
        // given
        val firstNumber = 2
        val secondNumber = 5
        val operator = Operator.MULTIPLY

        // when
        val actual = operator.operate(firstNumber, secondNumber)

        // then
        actual shouldBe 10
    }

    "두 숫자를 나눈다" {
        // given
        val firstNumber = 10
        val secondNumber = 2
        val operator = Operator.DIVIDE

        // when
        val actual = operator.operate(firstNumber, secondNumber)

        // then
        actual shouldBe 5
    }

    "연산자 기호로 연산자 객체를 찾는다" {
        forAll(
            row("+"),
            row("+"),
            row("+"),
            row("+"),
        ) {
            // when //then
            shouldNotThrowAny { Operator.of(it) }
        }
    }

    "적절하지 않은 연산자 기호로 연산자 객체를 찾는다" {
        forAll(
            row("!"),
            row("@"),
            row("#"),
            row("$"),
        ) {
            // when //then
            shouldThrowExactly<IllegalArgumentException> { Operator.of(it) }
        }
    }
})
