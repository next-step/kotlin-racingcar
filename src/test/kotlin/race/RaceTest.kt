package race

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import race.model.Car
import race.model.Race

class RaceTest : BehaviorSpec({
    given("레이스가 3대의 차와 3번 시도") {

        val cars = mutableListOf<Car>().apply {
            add(Car("aa", FakeEngine(FakeEngine.LOW_CYCLE)))
            add(Car("bb", FakeEngine(FakeEngine.HIGH_CYCLE)))
            add(Car("cc", FakeEngine(FakeEngine.HIGH_CYCLE)))
        }

        val race = Race(cars = cars, numberOfRace = 3)
        `when`("3대의 차") {
            then("차가 3대 이다")
            cars.size shouldBe 3
        }

        `when`("3번 시도") {
            then("3번시도")
            var count = 0
            race.startRacing {
                count++
            }
            count shouldBe 3
        }

        `when`("우승자는") {
            then("bb cc 이다") {
                val winner = race.startRacing()
                winner shouldBe "bb, cc"
            }
        }
    }

    given("a,b,c,d,e 차가 있다") {
        val fiveCars = mutableListOf<Car>().apply {
            add(Car("a", FakeEngine(FakeEngine.LOW_CYCLE)))
            add(Car("b", FakeEngine(FakeEngine.LOW_CYCLE)))
            add(Car("c", FakeEngine(FakeEngine.LOW_CYCLE)))
            add(Car("e", FakeEngine(FakeEngine.LOW_CYCLE)))
            add(Car("d", FakeEngine(FakeEngine.HIGH_CYCLE)))
        }
        val race = Race(cars = fiveCars, numberOfRace = 3)
        `when`("우승자는") {
            then("d 이다") {
                val winner = race.startRacing()
                winner shouldBe "d"
            }
        }
    }
})
