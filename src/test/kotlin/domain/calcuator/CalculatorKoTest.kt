package domain.calcuator

import domain.caculator.Calculator
import domain.caculator.Operator
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CalculatorKoTest : StringSpec({

    "계산이 올바른지 테스트 하기" {
        forAll(
            row(listOf(Operator.PLUS to 1, Operator.PLUS to 1), 2),
            row(listOf(Operator.PLUS to 1, Operator.MINUS to 1), 0),
            row(listOf(Operator.PLUS to 1, Operator.MULTIPLE to 1), 1),
            row(listOf(Operator.PLUS to 1, Operator.DIVISION to 1), 1),
            row(listOf(Operator.PLUS to 1, Operator.PLUS to 1, Operator.MINUS to 1), 1),
            row(listOf(Operator.PLUS to 1, Operator.MINUS to 2, Operator.MULTIPLE to 3), -3),
            row(listOf(Operator.PLUS to 1, Operator.MULTIPLE to 2, Operator.DIVISION to 2), 1),
            row(listOf(Operator.PLUS to 1, Operator.MULTIPLE to 3, Operator.MINUS to 2), 1),
            row(listOf(Operator.PLUS to 1, Operator.MULTIPLE to 1, Operator.PLUS to 4), 5)
        ) { expression, result ->
            val calculator = Calculator()

            calculator.calculate(expression) shouldBe result
        }
    }
})
