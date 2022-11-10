package racingcar.io

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockkObject
import racingcar.const.CarException

internal class InputViewTest : BehaviorSpec({
    Given("입력받은 값이") {
        mockkObject(Reader)
        When("null이라면") {
            every { Reader.read() } returns null
            Then("예외를 반환한다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    InputView.read()
                }
                exception.message shouldBe CarException.NULL_INPUT_ERROR
            }
        }

        When("숫자가 아니라면") {
            every { Reader.read() } returns "f12"
            Then("예외를 반환한다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    InputView.read()
                }
                exception.message shouldBe CarException.NOT_DIGIT_ERROR
            }
        }

        When("1 이상이 아니라면") {
            every { Reader.read() } returns "0"
            Then("예외를 반환한다.") {
                val exception = shouldThrow<IllegalArgumentException> {
                    InputView.read()
                }
                exception.message shouldBe CarException.MORE_THAN_ONE
            }
        }
    }
})
