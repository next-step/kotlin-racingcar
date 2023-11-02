package racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import racing.v1.InputView

class InputViewTest : BehaviorSpec({
    Given("비정상적인 입력값이 주어질 때") {
        When("자동차 대수 입력값을 null이거나 빈 문자열을 입력한 경우") {
            Then("IllegalArgumentException 예외를 던진다") {
                forAll(
                    row(null, "5"),
                    row("", "5"),
                    row("    ", "5"),
                ) { carCountStr: String?, tryCountStr: String? ->
                    shouldThrow<IllegalArgumentException> {
                        InputView.validateInput(carCountStr, tryCountStr)
                    }.message shouldBe "자동차 대수는 숫자로 입력해주세요."
                }
            }

            When("시도할 횟수 입력값을 null이거나 빈 문자열을 입력한 경우") {
                Then("IllegalArgumentException 예외를 던진다") {
                    forAll(
                        row("2", null),
                        row("2", ""),
                        row("2", "    "),
                    ) { carCountStr: String?, tryCountStr: String? ->
                        shouldThrow<IllegalArgumentException> {
                            InputView.validateInput(carCountStr, tryCountStr)
                        }.message shouldBe "시도할 횟수는 숫자로 입력해주세요."
                    }
                }
            }
        }
    }
})
