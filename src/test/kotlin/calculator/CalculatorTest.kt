package calculator

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
                shouldThrowMessage("수식의 개수가 1개면 숫자만 입력할 수 있습니다.") {
                    Calculator.calculate(expressions)
                }
            }
        }

        context("수식의 개수가 3개라면") {
            val expressions = listOf("10", "+", "5")

            it("계산 결과를 반환한다.") {
                Calculator.calculate(expressions) shouldBe 15.0
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

fun makeSampleExpressions(): List<Pair<List<String>, Double>> {
    return listOf(
        "1 + 2 * 4 - 2 / 2".split(" ").toList() to 5.0,
        "2 * 40 / 10 - 2 + 4".split(" ").toList() to 10.0,
        "1 - 1 + -1 + 1".split(" ").toList() to 0.0,
    )
}
