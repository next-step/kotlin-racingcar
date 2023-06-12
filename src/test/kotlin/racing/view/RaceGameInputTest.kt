package racing.view

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import racing.model.RaceGameErrorCode

class RaceGameInputTest : DescribeSpec({

    describe(name = "레이스 게임을 위한 Input 객체를 만들 때") {
        val names = "andy"
        val round = "123"

        context(name = "숫자 문자열을 입력하면") {
            val actual = RaceGameInput(
                carNamesInput = names,
                roundInput = round,
            )

            it(name = "숫자가 객체 내 저장된다.") {
                actual.carNames.firstOrNull() shouldBe names
                actual.round shouldBe round.toIntOrNull()
            }
        }

        val fiveNames = "andy,pobi,crong,honux,ace"

        context(name = "5대의 자동차를 입력하면") {
            val actual = RaceGameInput(
                carNamesInput = fiveNames,
                roundInput = round,
            )

            it(name = "다섯 대의 자동차가 저장된다.") {
                actual.carNames.size shouldBe 5
            }
        }

        val invalidString = "안녕하세요를레이요"
        val validNumberString = "123"

        context(name = "라운드에 숫자가 아닌 문자열을 입력하면") {
            val exception = shouldThrow<IllegalArgumentException> {
                RaceGameInput(
                    carNamesInput = validNumberString,
                    roundInput = invalidString,
                )
            }

            it(name = "라운드는 숫자형이어야 한다는 에러가 발생한다.") {
                exception shouldHaveMessage RaceGameErrorCode.INVALID_ROUND_INPUT.message(invalidString)
            }
        }
    }
})
