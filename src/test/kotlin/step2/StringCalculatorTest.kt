package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class StringCalculatorTest : StringSpec({

    "문자열 계산기 테스트" {
        // given
        val stringCalculator = StringCalculator()
        val input = "2 + 3 * 4 / 2"

        // when
        val actual = stringCalculator.calculate(input)

        // then
        actual shouldBe 10
    }

    "문자열 계산기 테스트 - 잘못된 입력값을 넣으면 에러가 발생한다." {
        // given
        val stringCalculator = StringCalculator()

        // when & then
        forAll(
            row(null),
            row(" "),
            row("2 ? 3")
        ) { wrongInput ->
            shouldThrow<IllegalArgumentException> {
                stringCalculator.calculate(wrongInput)
            }
        }
    }
})
