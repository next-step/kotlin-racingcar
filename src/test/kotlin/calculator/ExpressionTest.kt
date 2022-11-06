package calculator

import calculator.const.CalculatorException
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.stringPattern
import io.kotest.property.checkAll

internal class ExpressionTest : FunSpec({
    context("올바른 데이터는 검증에 성공한다.") {
        withData(
            nameFn = { "$it" },
            ts = listOf(
                listOf("2", "+", "2"),
                listOf("4", "/", "2", "+", "1")
            )
        ) { data ->
            shouldNotThrowAny {
                Expression(data)
            }
        }
    }

    context("올바른 데이터는 검증에 성공한다. [Property-Based-Test]") {
        val numberArb = Arb.stringPattern("[1-9]")
        val operatorArb = Arb.stringPattern("(\\+|\\-|\\/|\\*)")

        checkAll(numberArb, operatorArb, numberArb) { a, op, b ->
            shouldNotThrowAny {
                Expression(listOf(a, op, b))
            }
        }
    }

    context("올바르지 않은 데이터는 검증에 실패한다.") {
        withData(
            nameFn = { "$it" },
            ts = listOf(
                listOf("2", "+"),
                listOf("2", "+", "2", "-"),
                listOf("+", "+", "2")
            )
        ) { data ->
            shouldThrow<IllegalArgumentException> {
                Expression(data)
            }
        }
    }

    context("올바르지 않은 데이터는 검증에 실패한다. [Property-Based-Test]") {
        val numberArb = Arb.stringPattern("[1-9]")
        val operatorArb = Arb.stringPattern("(\\+|\\-|\\/|\\*)")

        context("사이즈가 3보다 작은 경우 실패한다.") {
            checkAll(numberArb, operatorArb) { a, op ->
                val exception = shouldThrow<IllegalArgumentException> {
                    Expression(listOf(a, op))
                }
                exception.message shouldBe CalculatorException.NOT_ENOUGH_SIZE
            }
        }

        context("홀수 개의 연산자와 짝수 개의 피연산자로 이루어져 있지 않다면 실패한다.") {
            checkAll(numberArb, operatorArb, numberArb, operatorArb) { a, op1, b, op2 ->
                val exception = shouldThrow<IllegalArgumentException> {
                    Expression(listOf(a, op1, b, op2))
                }
                exception.message shouldBe CalculatorException.NOT_PROPER_SIZE
            }
        }

        context("수식이 올바르지 않다면 실패한다.") {
            checkAll(operatorArb, operatorArb, numberArb) { op1, op2, a ->
                val exception = shouldThrow<IllegalArgumentException> {
                    Expression(listOf(op1, op2, a))
                }
                exception.message shouldBe CalculatorException.NOT_CORRECT_EXPRESSION
            }
        }
    }

    context("올바른 데이터의 계산을 진행한다.") {
        withData(
            nameFn = { "$it" },
            ts = listOf(
                listOf("2", "+", "2") to 4.0,
                listOf("4", "/", "2", "+", "1") to 3.0,
                listOf("5", "*", "4", "/", "4") to 5.0
            )
        ) { (data, result) ->
            Expression(data).calculate() shouldBe result
        }
    }

    context("나눗셈을 진행할 때, 피연산자가 0이라면 예외를 던진다.") {
        withData(
            nameFn = { "$it" },
            ts = listOf(
                listOf("4", "/", "0", "+", "1"),
            )
        ) { data ->
            val exception = shouldThrow<IllegalArgumentException> {
                Expression(data).calculate()
            }
            exception.message shouldBe CalculatorException.ZERO_DIVIDE_ERROR
        }
    }
})
