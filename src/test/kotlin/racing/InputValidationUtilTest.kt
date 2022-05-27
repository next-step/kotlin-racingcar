package racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class InputValidationUtilTest : FunSpec({

    context("inputConverter 단위테스트") {
        test("1 이상의 정수로 변환 가능한 입력값에 대한 변환은 성공한다") {
            // given
            forAll(
                row("2", 2),
                row("10", 10),
                row("100", 100)
            ) { input, expected ->
                // when
                val result = input.inputConverter()
                // then
                result shouldBe expected
            }
        }

        test("0 이하의 정수로 변환 가능한 입력값에 대한 변환은 실패한다") {
            forAll(
                row(" "),
                row("0"),
                row("11 "),
                row("-100")
            ) {
                shouldThrow<IllegalArgumentException> {
                    it.inputConverter()
                }
            }
        }
    }
})
