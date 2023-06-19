package race

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import race.model.Car
import race.model.Race

class RaceTest : BehaviorSpec({
    given("레이스가 3대의 차와 3번 시도") {

        val cars = listOf(
            Car("aa"),
            Car("bb"),
            Car("cc")
        )

        val race = Race(cars = cars, numberOfRace = 3, engine = FakeEngine(FakeEngine.HIGH_CYCLE))
        `when`("3대의 차") {
            then("차가 3대 이다")
            cars.size shouldBe 3
        }

        `when`("3번 시도 High Cycle 이기 때문에") {
            then("3번시도 position 는 3")
            var count = 0
            var position = 0
            race.start {
                count++
                position = it[0].position
            }
            count shouldBe 3
            position shouldBe 3
        }

    }
})
