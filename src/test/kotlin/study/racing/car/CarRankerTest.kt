package study.racing.car

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class CarRankerTest : StringSpec({

    val sut = CarRanker()

    "가장 많이 움직인 차량을 반환한다" {
        val expectedWinner = Car(name = "winner", 10)
        val cars = listOf(
            expectedWinner,
            Car(name = "loser1", 9),
            Car(name = "loser2", 0)
        )
        val actualWinners = sut.getWinners(cars)
        actualWinners shouldBe listOf(expectedWinner)
    }

    "가장 많이 움직인 차량이 여러대라면 여러대 모두 공동우승자이다" {
        val expectedWinner1 = Car(name = "winner", 10)
        val expectedWinner2 = Car(name = "winner1", 10)
        val cars = listOf(
            expectedWinner1,
            expectedWinner2,
            Car(name = "loser1", 9),
            Car(name = "loser2", 0)
        )

        val actualWinners = sut.getWinners(cars)
        actualWinners shouldBe listOf(expectedWinner1, expectedWinner2)
    }
})
