package racing

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarRacingTest : BehaviorSpec({
    given("몇 대의 자동차로 경주를 할 것인지를 전달하면") {
        val carCount = 3
        then("그에 맞는 배열이 생성되는가") {
            CarRacing.createCars(carCount) shouldBe List(carCount) { Car() }
        }
    }
})
