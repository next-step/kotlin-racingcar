package race

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import race.model.Race

class RaceTest : BehaviorSpec({
    given("레이스가 3대의 차와 3번 시도") {
        val race = Race(raceCars = listOf("aa", "bb", "cc"), numberOfRace = 3)
        `when`("3대의 차") {
            then("차가 3대 이다")
            race.getCarSize() shouldBe 3
        }

        `when`("3번 시도") {
            then("3번시도")
            var count = 0
            race.startRacing {
                count++
            }
            count shouldBe 3
        }
    }
})
