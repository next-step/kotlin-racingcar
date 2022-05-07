package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.arbitrary
import io.kotest.property.arbitrary.double
import io.kotest.property.arbitrary.merge
import io.kotest.property.arbitrary.negativeDouble
import io.kotest.property.arbitrary.positiveDouble
import io.kotest.property.checkAll

class CalculatorTest : FreeSpec({

    "calculate" - {

        "사칙연산 계산한 결과가 나와야한다." {
            withData(
                "2 + 3 * 4 / 2" to 10,
                "1 * 10 + 4 / 2" to 7,
            ) { (input, output) ->
                Calculator.calculate(input) shouldBe output
            }
        }
    }

    "splitInput" - {

        "입력이 정상적으로 이루어진 경우 문자열이 리스트로 분리되어야한다." {
            withData(
                "2 + 3 * 4 / 2" to listOf("2", "+", "3", "*", "4", "/", "2"),
                "1 * 10" to listOf("1", "*", "10"),
            ) { (input, output) ->
                Calculator.splitInput(input) shouldBe output
            }
        }

        "입력의 길이가 짝수인 경우 IllegalArgumentException" {
            val exception = shouldThrow<IllegalArgumentException> {
                Calculator.splitInput("2 +")
            }
            exception.message shouldBe ErrorMessage.INCORRECT_INPUT
        }
    }

    "computeByOperator" - {

        "덧셈인 경우" {
            checkAll<Double, Double> { acc, operand ->
                Calculator.computeByOperator("+", acc, operand) shouldBe acc + operand
            }
        }

        "뺄셈일 경우" {
            checkAll<Double, Double> { acc, operand ->
                Calculator.computeByOperator("-", acc, operand) shouldBe acc - operand
            }
        }

        "곱셈일 경우" {
            checkAll<Double, Double> { acc, operand ->
                Calculator.computeByOperator("*", acc, operand) shouldBe acc * operand
            }
        }

        "나눗셈일 경우" {
            val nonZeroDoubleArb = Arb.positiveDouble().merge(Arb.negativeDouble())

            checkAll(Arb.double(), nonZeroDoubleArb) { acc, operand ->
                Calculator.computeByOperator("/", acc, operand) shouldBe acc / operand
            }
        }

        "0으로 나눈 경우 IllegalArgumentException" {
            checkAll<Double> { acc ->
                val exception = shouldThrow<IllegalArgumentException> {
                    Calculator.computeByOperator("/", acc, 0.0)
                }
                exception.message shouldBe ErrorMessage.DIVIDE_BY_ZERO
            }
        }

        "사칙연산이 아닌 경우 IllegalArgumentException" {

            val validOperatorSet: Set<Char> = setOf('+', '-', '*', '/')

            val invalidOperator = CharRange(Char.MIN_VALUE, Char.MAX_VALUE) - validOperatorSet

            val invalidOperatorArb = arbitrary { rs ->
                val index: Int = rs.random.nextInt(invalidOperator.size)
                invalidOperator[index].toString()
            }

            checkAll(invalidOperatorArb, Arb.double(), Arb.double()) { operator, acc, operand ->
                val exception = shouldThrow<IllegalArgumentException> {
                    Calculator.computeByOperator(operator, acc, operand)
                }
                exception.message shouldBe ErrorMessage.INVALID_OPERATOR
            }
        }
    }
})
