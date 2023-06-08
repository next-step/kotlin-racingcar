package step3.view

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import step3.model.RaceGameErrorCode

class RaceGameInputTest : DescribeSpec({

    describe(name = "레이스 게임을 위한 Input 객체를 만들 때") {
        val expect = "123"

        context(name = "숫자 문자열을 입력하면") {
            val actual = RaceGameInput(
                carCountInput = expect,
                roundInput = expect,
            )

            it(name = "숫자가 객체 내 저장된다.") {
                actual.carCount shouldBe expect.toIntOrNull()
                actual.round shouldBe expect.toIntOrNull()
            }
        }

        val invalidString = "안녕하세요"
        val validNumberString = "123"

        context(name = "자동차 대수에 숫자가 아닌 문자열을 입력하면") {
            val exception = shouldThrow<IllegalArgumentException> {
                RaceGameInput(
                    carCountInput = invalidString,
                    roundInput = validNumberString,
                )
            }

            it(name = "자동차 대수는 숫자형이어야 한다는 에러가 발생한다.") {
                exception shouldHaveMessage RaceGameErrorCode.INVALID_CAR_COUNT_INPUT.message(invalidString)
            }
        }

        context(name = "라운드에 숫자가 아닌 문자열을 입력하면") {
            val exception = shouldThrow<IllegalArgumentException> {
                RaceGameInput(
                    carCountInput = validNumberString,
                    roundInput = invalidString,
                )
            }

            it(name = "라운드는 숫자형이어야 한다는 에러가 발생한다.") {
                exception shouldHaveMessage RaceGameErrorCode.INVALID_ROUND_INPUT.message(invalidString)
            }
        }
    }
})
