package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class WinnerTest : BehaviorSpec({

    given("자동차들이") {
        `when`("경기를 마쳤을 때") {
            then("우승자는 한명이다.") {
                val cars = Cars(onlyOneWinner)
                val winners = Winner.find(cars)
                winners.getWinners().size shouldBe 1
            }

            then("우승자는 여러명이다.") {
                val cars = Cars(multipleWinners)
                val winners = Winner.find(cars)
                winners.getWinners().size shouldBe 3
            }

            then("우승자는 없다.") {
                val cars = Cars(noOneWinner)
                val winners = Winner.find(cars)
                winners.getWinners().size shouldBe 0
            }
        }
    }
}) {
    companion object {
        private const val MAX_DISTANCE = 5
        private const val ZERO = 0

        private val onlyOneWinner = listOf(
            Car(Name("movingYB"), { true }, Distance(MAX_DISTANCE)),
            Car(Name("movingYB"), { false }, Distance(ZERO)),
            Car(Name("movingYB"), { false }, Distance(ZERO)),
            Car(Name("movingYB"), { false }, Distance(ZERO))
        )
        private val multipleWinners = listOf(
            Car(Name("movingYB"), { false }, Distance(ZERO)),
            Car(Name("movingYB"), { true }, Distance(MAX_DISTANCE)),
            Car(Name("movingYB"), { true }, Distance(MAX_DISTANCE)),
            Car(Name("movingYB"), { true }, Distance(MAX_DISTANCE))
        )
        private val noOneWinner = listOf(
            Car(Name("movingYB"), { false }, Distance(ZERO)),
            Car(Name("movingYB"), { false }, Distance(ZERO)),
            Car(Name("movingYB"), { false }, Distance(ZERO)),
            Car(Name("movingYB"), { false }, Distance(ZERO))
        )
    }
}
