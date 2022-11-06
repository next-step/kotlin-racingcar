package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class RacingGameTest : BehaviorSpec({

    given("Setting(numberOfCars = 3)이 주어지고") {
        val setting = Setting(numberOfCars = 3)

        `when`("게임을 시작하면") {
            then("배열의 길이가 3인 문자열 배열을 반환한다.") {
                RacingGame().start(setting).size shouldBe 3
            }
        }
    }

    given("Setting(numberOfCars = 1)과 무조건 전진하는 GoStop가 주어지고") {
        val setting = Setting(numberOfCars = 1)
        val movable = Movable(0)

        `when`("게임을 시작하면") {
            then("배열의 길이가 1이며 -----를 가지고 있는 문자열 배열을 반환한다.") {
                RacingGame(movable = movable).start(setting)[0] shouldBe "-----"
                RacingGame(movable = movable).start(setting).size shouldBe 1
            }
        }
    }
})
