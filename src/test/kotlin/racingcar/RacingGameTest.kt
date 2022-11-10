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

    given("Setting(numberOfCars = 1)과 무조건 전진하는 Movable 주어지고") {
        val setting = Setting(numberOfCars = 1)
        val movable = Movable(0)

        `when`("게임을 시작하면") {
            then("5의 진행도를 가진 자동차 한개를 가지고 있는 배열을 반환한다.") {
                RacingGame(movable = movable).start(setting)[0] shouldBe Car(_progress = 5)
                RacingGame(movable = movable).start(setting).size shouldBe 1
            }
        }
    }
})
