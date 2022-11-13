package racingcar

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.core.spec.style.BehaviorSpec

internal class GameTest : BehaviorSpec({
    Given("차의 개수와 시행 횟수가 주어지면") {
        val carNames = listOf("car1", "car2", "car3")
        val numberOfTry = 5
        val game = Game(carNames, numberOfTry)
        When("움직일 수 있는 조건이 true일 때 움직이려고 하면,") {
            Then("문제없이 앞으로 전진한다.") {
                shouldNotThrowAny {
                    game.execute()
                }
            }
        }
    }
})
