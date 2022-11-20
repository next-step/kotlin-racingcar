package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.RacingGame

class RacingGameTest : BehaviorSpec({

    given("Setting(nameOfCars = [홍종표,강현석,박재성])이 주어지고") {
        val setting = Setting.byCarNames(listOf("홍종표", "강현석", "박재성"))

        `when`("게임을 생성하면") {

            val game = RacingGame(setting.cars, setting.numberOfLab)

            then("게임 중이라는 값을 반환한다") {
                game.isPlaying shouldBe true
            }
        }
    }

    given("Setting(nameOfCars = [홍종표,강현석,박재성])로 만든 주어지고") {
        val setting = Setting.byCarNames(listOf("홍종표", "강현석", "박재성"))
        val game = RacingGame(setting.cars, setting.numberOfLab)

        `when`("게임을 플레이 하면") {

            val result = game.playTurn()

            then("자동차들의 해당 턴의 결과를 받을 수 있다") {
                result.cars.size shouldBe 3
            }
        }
    }

    given("Setting(numberOfLab = 1)로 만든 Game 이 주어지고") {

        val setting = Setting.byCarNames(listOf("홍종표"), 1)
        val game = RacingGame(setting.cars, setting.numberOfLab)

        `when`("한 턴 플레이하기 전에는") {
            then("게임 중이라는 값을 반환한다") {
                game.isPlaying shouldBe true
            }
        }

        `when`("게임을 한 턴 플레이하면") {
            game.playTurn()
            then("게임 중이지 않다는 값을 반환한다") {
                game.isPlaying shouldBe false
            }
        }
    }
})
