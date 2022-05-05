package calculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

internal class StringCalculatorTest : StringSpec({
    "수식이 비어있으면 예외를 던진다" {
        forAll(
            row(""),
            row("   "),
        ) {
            //when //then
            shouldThrowExactly<IllegalArgumentException> { StringCalculator(it) }
        }
    }

    "주어진 문자열 수식을 연산한다" {
        //given
        val expression = "2 + 3 * 4 / 2"
        val stringCalculator = StringCalculator(expression)

        //when
        val actual = stringCalculator.calculate()

        //then
        actual shouldBe 10
    }
})
