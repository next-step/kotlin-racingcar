package operation

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class FourBasicOperationsTest : StringSpec({
    val operations = FourBasicOperations()

    fun testCalculate(
        expression: String,
        expected: Int,
    ) {
        operations.calculate(expression) shouldBe expected
    }

    fun testParseNumbers(
        expression: String,
        expected: List<Int>,
    ) {
        operations.parseNumbers(expression) shouldBe expected
    }

    fun testParseOperators(
        expression: String,
        expected: List<Operator>,
    ) {
        operations.parseOperators(expression) shouldBe expected
    }

    fun testException(expression: String) {
        shouldThrow<IllegalArgumentException> {
            operations.calculate(expression)
        }
    }

    "calculate test 1" {
        testCalculate("2 + 3 * 4 / 2 - 3", 5)
    }

    "calculate test 2" {
        testCalculate("4 * 2 * 3 / 6 + 5 - 1", 8)
    }

    "parseNumbers test 1" {
        testParseNumbers("2 + 3 * 4 / 2 - 3", listOf(2, 3, 4, 2, 3))
    }

    "parseNumbers test 2" {
        testParseNumbers("4 * 2 * 3 / 6 + 5 - 1", listOf(4, 2, 3, 6, 5, 1))
    }

    "parseOperators test 1" {
        testParseOperators(
            "2 + 3 * 4 / 2 - 3",
            listOf(Operator.SUM, Operator.MULTIPLY, Operator.DIVIDE, Operator.SUBTRACT),
        )
    }

    "parseOperators test 2" {
        testParseOperators(
            "4 * 2 * 3 / 6 + 5 - 1",
            listOf(Operator.MULTIPLY, Operator.MULTIPLY, Operator.DIVIDE, Operator.SUM, Operator.SUBTRACT),
        )
    }

    "연산 기호 예외 테스트" { testException("2 + 3 % 4") }

    "빈 공백 문자 예외 테스트" { testException("2 + + 3") }

    "null 예외 테스트" { testException(null.toString()) }

    "빈 문자 예외 테스트" { testException("") }
})
