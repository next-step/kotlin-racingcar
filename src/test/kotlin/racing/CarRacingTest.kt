package racing

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldBeSameSizeAs

class CarRacingTest : BehaviorSpec({
    given("몇 대의 자동차로 몇 번의 이동을 할 것인지를 전달하여") {
        val (carCount, tryCount) = 3 to 5
        `when`("자동차 경주를 하면") {
            then("그에 맞는 크기의 결과를 담은 이차원 배열이 생성되는가") {
                CarRacing.race(carCount, tryCount) shouldBeSameSizeAs List(tryCount) { List(carCount) { Car() } }
            }
        }
    }
})
