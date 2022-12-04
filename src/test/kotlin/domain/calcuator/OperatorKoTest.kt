package domain.calcuator

import domain.caculator.Operator
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import java.lang.IllegalArgumentException

class OperatorKoTest : StringSpec({

    "연산자 테스트" {
        forAll(
            row(Operator.PLUS, 1, 1, 2),
            row(Operator.MINUS, 1, 1, 0),
            row(Operator.MULTIPLE, 1, 1, 1),
            row(Operator.DIVISION, 1, 1, 1)
        ) { operator, number1, number2, result ->
            operator.calculate(number1, number2) shouldBe result
        }
    }

    "정상적인 symbol이 들어오면 Operator를 리턴한다" {
        forAll(
            row("+", Operator.PLUS),
            row("-", Operator.MINUS),
            row("*", Operator.MULTIPLE),
            row("/", Operator.DIVISION)
        ) { symbol, operator ->
            Operator.of(symbol) shouldBe operator
        }
    }

    "잘못된 symbol이 들어오면 에러가 반환된다" {
        val strings = listOf("1", "=", "[", "]")
        strings.forEach {
            val message = shouldThrow<IllegalArgumentException> { Operator.of(it) }

            message shouldHaveMessage "잘못된 연산자 입니다."
        }
    }
})
