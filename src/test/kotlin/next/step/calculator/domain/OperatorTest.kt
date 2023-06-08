package next.step.calculator.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class OperatorTest : FunSpec({

    context("사칙연산 기호로 Operator 생성") {
        data class SymbolExpected(val symbol: String, val expected: Operator)
        withData(
            nameFn = { "\"${it.symbol}\" : Operator.${it.expected}" },
            SymbolExpected("+", Operator.PLUS),
            SymbolExpected("-", Operator.MINUS),
            SymbolExpected("*", Operator.TIMES),
            SymbolExpected("/", Operator.DIVIDE),
        ) { (symbol, expected) ->
            Operator.from(symbol) shouldBe expected
        }
    }

    context("공백으로 Operator 생성시 예외 발생") {
        withData(
            nameFn = { "\"${it}\"" },
            listOf("", " ", "      ")
        ) { spaces ->
            shouldThrow<IllegalArgumentException> {
                Operator.from(spaces)
            }
        }
    }

    context("공백이 아니고 사칙연산 기호가 아니면 Operator 생성시 예외 발생") {
        withData(
            nameFn = { "\"${it}\"" },
            listOf("eng", "한글", ".")
        ) { invalidSymbol ->
            shouldThrow<IllegalArgumentException> {
                Operator.from(invalidSymbol)
            }
        }
    }

    context("각 Operator로 사칙연산 수행") {
        data class EvaluateExpected(val operator: Operator, val a: Int, val b: Int, val expected: Int)
        withData(
            nameFn = { "${it.a} ${it.operator.symbol} ${it.b} = ${it.expected}" },
            EvaluateExpected(Operator.PLUS, 20, 10, 30),
            EvaluateExpected(Operator.MINUS, 20, 10, 10),
            EvaluateExpected(Operator.TIMES, 20, 10, 200),
            EvaluateExpected(Operator.DIVIDE, 20, 10, 2),
        ) { (operator, a, b, expected) ->
            operator.evaluate(InputNumber(a), InputNumber(b)) shouldBe InputNumber(expected)
        }
    }
})
