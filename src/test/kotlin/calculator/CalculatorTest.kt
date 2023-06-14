package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({

    "계산기는 입력 받은 값에 대한 연산을 수행한다." {
        forAll(
            row("1 + 2 / 3", 1),
            row("5 * 3", 15),
            row("10 / 2 * 10 + 1", 51),
            row("4 - 2 * 20", 40),
            row("3 * 2 + 5 - 1", 10),
            row("2 + 3 * 4 - 1", 19)
        ) { inputData, expected ->
            val expression = TokenizedExpression(inputData)
            val calculator = Calculator(expression)
            val result = calculator.calculate()
            result shouldBe expected
        }
    }

    "비정상적인 데이터가 있을 경우 예외를 발생시킨다." {
        forAll(
            row("10 % 2"),
            row("asdf"),
            row("  10 * 5"),
            row("10 a 5"),
            row("안녕"),
            row(""),
        ) { expressionStr ->
            val expression = TokenizedExpression(expressionStr)
            val calculator = Calculator(expression)
            shouldThrow<IllegalArgumentException> {
                calculator.calculate()
            }
        }
    }
})
