package race

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import race.model.Car
import race.model.Winner

class WinnerTest : BehaviorSpec({
    given("a,b,c,d,e 차가 있다") {
        val fiveCars = listOf(
            Car("a"),
            Car("b", position = 2),
            Car("c", position = 4),
            Car("d", position = 6),
            Car("e", position = 6)
        )
        val winner = Winner(fiveCars)
        `when`("우승자는") {
            then("d, e 이다") {
                winner.getWinner() shouldBe "d, e"
            }
        }
    }

    given("a,b,c,d차가 있다") {
        val cars = listOf(
            Car("a"),
            Car("b", position = 4),
            Car("c", position = 2),
            Car("e", position = 1),
        )
        val winner = Winner(cars)
        `when`("우승자는") {
            then("b 이다") {
                winner.getWinner() shouldBe "b"
            }
        }
    }
})
