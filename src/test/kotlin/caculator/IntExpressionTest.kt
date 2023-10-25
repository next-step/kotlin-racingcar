package caculator

import calculator.IntExpression
import calculator.Operator
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class IntExpressionTest : StringSpec({
    "식으로 만들 수 있는 문자열일 경우 식이 만들어진다" {
        val input = "1 + 3 * 2"

        val result = IntExpression.of(input)

        result.initialNumber shouldBe 1
        result.operations.size shouldBe 2
        result.operations[0] shouldBe IntExpression.Operation(Operator.ADD, 3)
        result.operations[1] shouldBe IntExpression.Operation(Operator.MULTIPLY, 2)
    }

    "숫자 한개로 식이 만들어진다" {
        val input = "1"

        val result = IntExpression.of(input)

        result.initialNumber shouldBe 1
        result.operations.size shouldBe 0
    }

    "문자열 중간에 공백이 추가로 포함되어 있더라도 식이 만들어진다" {
        val input = "1   + 3 * 2 "

        val result = IntExpression.of(input)

        result.initialNumber shouldBe 1
        result.operations.size shouldBe 2
        result.operations[0] shouldBe IntExpression.Operation(Operator.ADD, 3)
        result.operations[1] shouldBe IntExpression.Operation(Operator.MULTIPLY, 2)
    }

    "빈 문자열을 식으로 만들 경우 예외가 발생한다" {
        shouldThrowExactly<IllegalArgumentException> {
            IntExpression.of("")
        }
    }

    "공백으로만 구성된 문자열을 식으로 만들 경우 예외가 발생한다" {
        forAll(
            row(" "),
            row("  "),
        ) { input ->
            shouldThrowExactly<IllegalArgumentException> {
                IntExpression.of(input)
            }
        }
    }

    "공백이 구분자가 아닌 문자열로 식으로 만들 경우 예외가 발생한다" {
        forAll(
            row("3+4"),
            row("3:+4"),
        ) { input ->
            shouldThrowExactly<IllegalArgumentException> {
                IntExpression.of(input)
            }
        }
    }

    "수가 들어갈 위치가 양수가 아닌 문자가 들어간 문자열로 식을 만들 경우 예외가 발생한다" {
        forAll(
            row("3 + -13 * 2"),
            row("3 + ? * 2")
        ) { input ->
            shouldThrowExactly<IllegalArgumentException> {
                IntExpression.of(input)
            }
        }
    }

    "식이 성립하지 않는 문자열을 식으로 만들 경우 예외가 발생한다" {
        forAll(
            row("3 + 4 * 2 +"),
            row("3 ! 4 * 2 +")
        ) { input ->
            shouldThrowExactly<IllegalArgumentException> {
                IntExpression.of(input)
            }
        }
    }
})
