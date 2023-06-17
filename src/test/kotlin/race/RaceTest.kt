package race

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import race.model.Car
import race.model.Race

class RaceTest : BehaviorSpec({
    given("레이스가 3대의 차와 3번 시도") {

        val cars = mutableListOf<Car>().apply {
            add(Car("aa"))
            add(Car("bb"))
            add(Car("cc"))
        }

        val race = Race(cars = cars, numberOfRace = 3)
        `when`("3대의 차") {
            then("차가 3대 이다")
            cars.size shouldBe 3
        }

        `when`("3번 시도") {
            then("3번시도")
            var count = 0
            race.start {
                count++
            }
            count shouldBe 3
        }
    }
})
