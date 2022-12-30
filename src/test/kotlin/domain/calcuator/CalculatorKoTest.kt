package domain.calcuator

import domain.caculator.Calculator
import domain.caculator.Operator
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CalculatorKoTest : DescribeSpec({

    describe("계산이 올바른지 테스트 하기") {
        forAll(
            row(listOf(Operator.PLUS to 1, Operator.PLUS to 1), 2, "1 + 1 = 2"),
            row(listOf(Operator.PLUS to 1, Operator.MINUS to 1), 0, "1 - 1 =0"),
            row(listOf(Operator.PLUS to 1, Operator.MULTIPLE to 1), 1, "1 * 1 = 1"),
            row(listOf(Operator.PLUS to 1, Operator.DIVISION to 1), 1, "1 / 1 = 1"),
            row(listOf(Operator.PLUS to 1, Operator.PLUS to 1, Operator.MINUS to 1), 1, "1 + 1 - 1 = 1"),
            row(listOf(Operator.PLUS to 1, Operator.MINUS to 2, Operator.MULTIPLE to 3), -3, "1 - 2 + 3 = -3"),
            row(listOf(Operator.PLUS to 1, Operator.MULTIPLE to 2, Operator.DIVISION to 2), 1, "1 * 2 / 2 = 1"),
            row(listOf(Operator.PLUS to 1, Operator.MULTIPLE to 3, Operator.MINUS to 2), 1, "1 * 3 - 2 = 1"),
            row(listOf(Operator.PLUS to 1, Operator.MULTIPLE to 1, Operator.PLUS to 4), 5, "1 * 1 + 4 = 5")
        ) { expression, result, description ->
            it(description) {
                val calculator = Calculator()

                calculator.calculate(expression) shouldBe result
            }
        }
    }
})
