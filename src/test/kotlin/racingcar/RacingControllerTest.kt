package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.RacingPlayers
import racingcar.domain.RacingPlayersValidation
import racingcar.domain.RacingProperty
import racingcar.domain.RacingRule
import racingcar.domain.RacingWinner
import java.lang.IllegalArgumentException

class RacingControllerTest : BehaviorSpec({
    val intRandomGenerator = { start: Int, end: Int -> IntRange(start, end).random() }
    val alwaysForward = RacingProperty(5, 9, Racing.MOVE_FORWARD_CONDITION)
    val nameLengthIsLessThan = RacingPlayersValidation { it -> it.names.all { RacingPlayersValidation.NAME_MAX_LENGTH > it.length } }

    Given("자동차 이름과 시도 횟수, 경기 규칙을 준비하여") {
        val racingPlayers = RacingPlayers("aaa,bbb,ccc", 5, nameLengthIsLessThan)
        When("자동차 경주를 시작하면") {
            val racingRule = RacingRule(
                intRandomGenerator,
                alwaysForward
            )
            val result = RacingController(racingPlayers).start(racingRule)
            Then("경기 결과를 반환하며 우승자를 확인할 수 있다.") {
                result.getRacingWinners() shouldBe listOf(
                    RacingWinner("aaa"),
                    RacingWinner("bbb"),
                    RacingWinner("ccc")
                )

                result.allRounds.size shouldBe 5
            }
        }
    }

    Given("자동차의 이름이 5글자를 초과하는 경우") {
        When("자동차 선수 객체를 생성할 때") {
            Then("예외를 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    RacingPlayers("aaaaaaa,b,c", 5, nameLengthIsLessThan)
                }
            }
        }
    }
})
