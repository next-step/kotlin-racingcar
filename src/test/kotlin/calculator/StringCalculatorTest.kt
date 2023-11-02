package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.WithDataTestName
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class StringCalculatorTest : FunSpec({

    context("사칙연산") {
        withData(
            StringCalculatorTestData("1 + 2", 3),
            StringCalculatorTestData("1 - 2", -1),
            StringCalculatorTestData("3 * 2", 6),
            StringCalculatorTestData("6 / 2", 3),
            StringCalculatorTestData("6 / 2 + 20 - 4 * 10", 190),
        ) { (input, result) ->
            StringCalculator.calculate(input) shouldBe result
        }
    }

    context("0으로 나누는 경우 IllegalArgumentException throw") {
        withData(
            nameFn = { "input : $it" },
            "2 / 0",
            "0 / 0",
            "1 / 0",
        ) { input ->
            val exception = shouldThrow<IllegalArgumentException> {
                StringCalculator.calculate(input)
            }
            exception.localizedMessage shouldBe "0으로 나눌 수 없습니다."
        }
    }

    context("입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw") {
        withData(
            nameFn = { if (it == null) "input : $it" else "input : \"${it}\"" },
            null,
            "",
            "         ",
        ) { input ->
            shouldThrow<IllegalArgumentException> { StringCalculator.calculate(input) }
        }
    }

    context("사칙연산 기호가 아닌 경우 IllegalArgumentException throw") {
        withData(
            nameFn = { "input : $it" },
            "2 = 5",
            "2 a 5",
            "2 ^ 5",
            "2 + 3 * 4 1 2 "
        ) { input ->
            shouldThrow<IllegalArgumentException> { StringCalculator.calculate(input) }
        }
    }

    context("피연산자 자리에 수가 들어오지 않은 경우 IllegalArgumentException throw") {
        withData(
            nameFn = { "input : $it" },
            "2 / +",
            "+ 0 + ",
            "* / 1",
        ) { input ->
            shouldThrow<IllegalArgumentException> { StringCalculator.calculate(input) }
        }
    }
})

data class StringCalculatorTestData(val input: String, val result: Long) : WithDataTestName {
    override fun dataTestName(): String = "$input = $result"
}
