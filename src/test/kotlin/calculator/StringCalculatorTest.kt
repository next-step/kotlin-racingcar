package calculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row

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
})
