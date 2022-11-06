package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.double
import io.kotest.property.arbitrary.merge
import io.kotest.property.arbitrary.negativeDouble
import io.kotest.property.arbitrary.positiveDouble
import io.kotest.property.checkAll
import java.lang.IllegalArgumentException

internal class OperatorTest : FunSpec({
    context("올바른 연산자 문자에 대해 올바른 연산자를 찾아온다.") {
        withData(
            nameFn = { "올바른 연산자 문자 테스트 ${it.first}" },
            ts = listOf(
                "+" to Operator.ADD,
                "-" to Operator.MINUS,
                "/" to Operator.DIVIDE,
                "*" to Operator.MULTIPLY
            )
        ) { (op, operator) ->
            Operator.from(op) shouldBe operator
        }
    }

    context("올바르지 않은 연산자 문자에 대해 예외를 던진다.") {
        withData(
            nameFn = { "올바르지 않은 연산자 문자 테스트 $it" },
            ts = listOf("(", ")", "%", "$")
        ) { op ->
            shouldThrow<IllegalArgumentException> {
                Operator.from(op)
            }
        }
    }

    context("연산자는 연산을 진행할 수 있다.") {
        withData(
            nameFn = { "${it.a} ${it.operator.op} ${it.b} = ${it.result}" },
            ts = listOf(
                OperatorTestData(operator = Operator.ADD, a = 1.0, b = 2.0, result = 3.0),
                OperatorTestData(operator = Operator.MINUS, a = 1.0, b = 2.0, result = -1.0),
                OperatorTestData(operator = Operator.DIVIDE, a = 4.0, b = 2.0, result = 2.0),
                OperatorTestData(operator = Operator.MULTIPLY, a = 3.0, b = 2.0, result = 6.0)
            )
        ) { (operator, a, b, result) ->
            operator(a, b) shouldBe result
        }
    }

    context("올바른 연산자 문자에 대해 올바른 연산을 진행한다.[Property-Based-Test]") {
        context("덧셈") {
            checkAll<Double, Double> { a, b ->
                Operator.ADD(a, b) shouldBe (a + b)
            }
        }

        context("뺄셈") {
            checkAll<Double, Double> { a, b ->
                Operator.MINUS(a, b) shouldBe (a - b)
            }
        }

        context("나눗셈") {
            val doubleArb = Arb.double()
            val nonZeroDoubleArb = Arb.positiveDouble().merge(Arb.negativeDouble())

            checkAll(doubleArb, nonZeroDoubleArb) { a, b ->
                Operator.DIVIDE(a, b) shouldBe (a / b)
            }
        }

        context("곱셈") {
            checkAll<Double, Double> { a, b ->
                Operator.MULTIPLY(a, b) shouldBe (a * b)
            }
        }
    }
})

data class OperatorTestData(
    val operator: Operator,
    val a: Double,
    val b: Double,
    val result: Double
)
