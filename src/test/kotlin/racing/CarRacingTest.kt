package racing

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldBeSameSizeAs
import io.kotest.matchers.shouldBe

class CarRacingTest : BehaviorSpec({
    given("경주할 자동차의 이름과 몇 번의 이동을 할 것인지를 전달하여") {
        val (carNames, tryCount) = "pobi,crong,honux".split(",") to 5
        `when`("자동차 경주를 하면") {
            val cars = CarRacingStarter().ready(carNames)
            val (results, winners) = CarRacing().race(cars, tryCount)
            then("그에 맞는 크기의 결과가 생성되는가") {
                results shouldBeSameSizeAs List(tryCount) { carNames }
            }
            then("우승자는 가장 많이 움직인 자동차와 같다.") {
                winners shouldBe CarRacingRecorder.findWinners(cars)
            }
        }
    }
})
