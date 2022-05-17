package calculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldEndWith

internal class CalculatorTest : FreeSpec({

    "전달된 수식 문자열이 공백인 경우 예외가 발생한다." {
        val calculator = Calculator()
        shouldThrowExactly<IllegalArgumentException> { calculator.calculate(" ") }
    }

    "연산자와 피연산자 개수가 올바르지 않은 경우 예외가 발생한다." - {
        listOf(
            "3 +",
            "5 + 2 -"
        ).forEach { invalidValue ->
            "$invalidValue 는 예외가 발생한다." {
                // when
                val exception = shouldThrowExactly<IllegalArgumentException> { Calculator().calculate(invalidValue) }

                // then
                exception.message shouldBe "입력된 수식이 올바르지 않습니다."
            }
        }
    }

    "피연산자가 있어야할 순서에 연산자가 있으면 예외가 발생한다." - {
        listOf(
            "+",
            "/ 4 + 2",
            "+ + 3 + 1",
            "3 + 5 - -"
        ).forEach { invalidValue ->
            "$invalidValue 는 예외가 발생한다." {
                // when
                val exception = shouldThrowExactly<IllegalArgumentException> { Calculator().calculate(invalidValue) }

                // then
                exception.message shouldEndWith "는 정수가 아닙니다."
            }
        }
    }

    "연산자가 있어야할 순서에 피연산자가 있으면 예외가 발생한다." - {
        listOf(
            "3 3",
            "4 + 2 0",
            "4 3 1"
        ).forEach { invalidValue ->
            "$invalidValue 는 예외가 발생한다." {
                // when
                val exception = shouldThrowExactly<IllegalArgumentException> { Calculator().calculate(invalidValue) }

                // then
                exception.message shouldEndWith "에 해당하는 연산자를 찾지 못했습니다."
            }
        }
    }
})
