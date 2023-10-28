package racing

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldBeSameSizeAs

class CarRacingTest : BehaviorSpec({
    given("경주할 자동차의 이름과 몇 번의 이동을 할 것인지를 전달하여") {
        val (carNames, tryCount) = "pobi,crong,honux".split(",") to 5
        `when`("자동차 경주를 하면") {
            then("그에 맞는 크기의 결과를 담은 이차원 배열이 생성되는가") {
                CarRacing.race(carNames, tryCount) shouldBeSameSizeAs List(tryCount) { carNames.map { Car(it) } }
            }
        }
    }
})
