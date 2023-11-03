package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import java.lang.IllegalArgumentException

class RacingPlayersTest : BehaviorSpec({

    Given("자동차 이름들과 시도 횟수가 주어지고") {
        val nameOfCars = "aaaaaa,bb,c"
        val numberOfTrials = 3
        val nameLengthIsLessThan = RacingPlayersValidation { it -> it.names.all { RacingPlayersValidation.NAME_MAX_LENGTH > it.length } }
        When("자동차 이름이 특정 길이를 넘어선다면") {
            Then("자동차 선수 객체를 생성할 때 예외를 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    RacingPlayers(nameOfCars, numberOfTrials, nameLengthIsLessThan)
                }
            }
        }
    }
})
