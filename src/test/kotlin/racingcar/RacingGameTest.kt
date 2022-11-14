package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.Setting

class RacingGameTest : BehaviorSpec({

    given("Setting(nameOfCars = [홍종표,강현석,박재성])이 주어지고") {
        val setting = Setting(listOf("홍종표", "강현석", "박재성"))

        `when`("게임을 시작하면") {
            then("배열의 길이가 3인 문자열 배열을 반환한다.") {
                RacingGame().run(setting).size shouldBe 3
            }
        }
    }
})
