package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class OperatorTest: StringSpec({
    "두 숫자를 더한다" {
        //given
        val firstNumber = 1
        val secondNumber = 2
        val operator = Operator.PLUS

        //when
        val actual = operator.operate(firstNumber, secondNumber)

        //then
        actual shouldBe 3
    }

    "두 숫자를 뺀다" {
        //given
        val firstNumber = 2
        val secondNumber = 1
        val operator = Operator.MINUS

        //when
        val actual = operator.operate(firstNumber, secondNumber)

        //then
        actual shouldBe 1
    }

    "두 숫자를 곱한다" {
        //given
        val firstNumber = 2
        val secondNumber = 5
        val operator = Operator.MULTIPLY

        //when
        val actual = operator.operate(firstNumber, secondNumber)

        //then
        actual shouldBe 10
    }

    "두 숫자를 나눈다" {
        //given
        val firstNumber = 10
        val secondNumber = 2
        val operator = Operator.DIVIDE

        //when
        val actual = operator.operate(firstNumber, secondNumber)

        //then
        actual shouldBe 5
    }
})
