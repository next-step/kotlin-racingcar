package calculator

import calculator.Operator.ADDITION
import calculator.Operator.DIVISION
import calculator.Operator.MULTIPLICATION
import calculator.Operator.SUBTRACTION
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class OperatorTest : FreeSpec({

    "문자열로 덧셈 연산자를 찾을 수 있다." - {
        // when
        val operator = Operator.findBySign(sign = "+")

        // then
        operator shouldBe ADDITION
    }

    "문자열로 뺄셈 연산자를 찾을 수 있다." - {
        // when
        val operator = Operator.findBySign(sign = "-")

        // then
        operator shouldBe SUBTRACTION
    }

    "문자열로 곱셈 연산자를 찾을 수 있다." - {
        // when
        val operator = Operator.findBySign(sign = "*")

        // then
        operator shouldBe MULTIPLICATION
    }

    "문자열로 나눗셈 연산자를 찾을 수 있다." - {
        // when
        val operator = Operator.findBySign(sign = "/")

        // then
        operator shouldBe DIVISION
    }

    "문자열에 해당되는 연산자가 없는 경우 예외가 발생한다." - {
        // when
        val invalidSign = "#"
        val exception = shouldThrowExactly<IllegalArgumentException> { Operator.findBySign(sign = invalidSign) }

        // then
        exception.message shouldBe "$invalidSign 에 해당하는 연산자를 찾지 못했습니다."
    }

    "NumberVO로 주어진 값을 더할 수 있다." - {
        listOf(
            row(3, 4, 7),
            row(-9, 5, -4),
            row(-1, -1, -2)
        ).forEach { (a, b, result) ->
            "$a + $b = $result"  {
                ADDITION.calculate(Number(a), Number(b)).value shouldBe result
            }
        }
    }

    "NumberVO로 주어진 값을 뺄 수 있다." - {
        listOf(
            row(3, 4, -1),
            row(-9, 5, -14),
            row(-1, -1, 0)
        ).forEach { (a, b, result) ->
            "$a + $b = $result"  {
                SUBTRACTION.calculate(Number(a), Number(b)).value shouldBe result
            }
        }
    }

    "NumberVO로 주어진 값을 곱할 수 있다." - {
        listOf(
            row(3, 4, 12),
            row(-9, 5, -45),
            row(-1, -1, 1)
        ).forEach { (a, b, result) ->
            "$a + $b = $result"  {
                MULTIPLICATION.calculate(Number(a), Number(b)).value shouldBe result
            }
        }
    }

    "NumberVO로 주어진 값을 나눌 수 있다." - {
        listOf(
            row(3, 4, 0),
            row(9, 3, 3),
            row(-9, 5, -1),
            row(-1, -1, 1)
        ).forEach { (a, b, result) ->
            "$a + $b = $result"  {
                DIVISION.calculate(Number(a), Number(b)).value shouldBe result
            }
        }
    }
})
