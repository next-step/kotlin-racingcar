package race

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import race.model.Car
import race.model.Race
import race.model.Winner

class WinnerTest : BehaviorSpec({
    given("a,b,c,d,e 차가 있다") {
        val fiveCars = mutableListOf<Car>().apply {
            add(Car("a"))
            add(Car("b", position = 2))
            add(Car("c", position = 4))
            add(Car("d", position = 6))
            add(Car("e", position = 6))
        }
        val winner = Winner(fiveCars)
        `when`("우승자는") {
            then("d, e 이다") {
                winner.getWinner() shouldBe "d, e"
            }
        }
    }

    given("a,b,c,d차가 있다") {
        val cars = mutableListOf<Car>().apply {
            add(Car("a"))
            add(Car("b", position = 4))
            add(Car("c", position = 2))
            add(Car("e", position = 1))
        }
        val winner = Winner(cars)
        `when`("우승자는") {
            then("b 이다") {
                winner.getWinner() shouldBe "b"
            }
        }
    }
})
