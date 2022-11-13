package racingcar

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class CarsTest : BehaviorSpec({

    given("항상 움직이는 전략을 가진 2대의 자동차가") {
        val cars = Cars(listOf("a", "b").map { Car(name = it, strategy = { true }) })

        `when`("5번의 시도횟수를 가지면") {
            val tryCount = 5
            cars.game(tryCount)

            then("5번 전진한다.") {
                cars.getCars().forEach {
                    it.getDistance() shouldBe 5
                }
            }
        }
    }
})
