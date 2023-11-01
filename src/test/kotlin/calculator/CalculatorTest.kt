package calculator

import calculator.operand.Operand
import io.kotest.assertions.throwables.shouldThrowMessage
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : DescribeSpec({

    describe("calculate") {
        context("수식의 개수가 짝수면") {
            val expressions = listOf(
                "1", "+", "2", "-"
            )

            it("예외가 발생한다.") {
                shouldThrowMessage("수식이 올바르지 않습니다.") {
                    Calculator.calculate(expressions)
                }
            }
        }

        context("수식의 개수가 1개일 때, 해당 값이 숫자가 아니라면") {
            val expressions = listOf("*")

            it("예외가 발생한다.") {
                shouldThrowMessage("숫자가 아닙니다. 현재 입력값: *") {
                    Calculator.calculate(expressions)
                }
            }
        }

        context("사칙연산 기호가 아닌 다른 연산자가 들어왔다면") {
            val expressions = listOf("1", "?", "3")

            it("예외가 발생한다.") {
                shouldThrowMessage("지원하지 않는 연산자입니다.") {
                    Calculator.calculate(expressions)
                }
            }
        }

        makeSampleExpressions().forEach { (expressions, result) ->
            context("수식이 주어지면 (수식: $expressions)") {
                it("계산 결과를 반환한다.") {
                    Calculator.calculate(expressions) shouldBe result
                }
            }
        }
    }
})

fun makeSampleExpressions(): List<Pair<List<String>, Operand>> {
    return listOf(
        "1 + 2 * 4 - 2 / 2".split(" ").toList() to Operand.of(5.0),
        "2 * 40 / 10 - 2 + 4".split(" ").toList() to Operand.of(10.0),
        "1 - 1 + -1 + 1".split(" ").toList() to Operand.of(0.0),
    )
}
