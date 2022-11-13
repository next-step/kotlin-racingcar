package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveAtLeastSize
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

internal class TrackTest : StringSpec({
    val track = Track(RandomForward())

    "우승자를 선출한다." {
        val maxPosition = 10
        val minPosition = 0
        val cars = listOf(
            Car("winner", maxPosition),
            Car("loser", minPosition)
        )

        val winners: List<Car> = track.getWinner(cars)

        winners shouldHaveSize 1
        winners.first().name shouldBe "winner"
    }

    "우승자는 1명 이상일 수 있다." {
        val maxPosition = 10
        val minPosition = 0
        val cars = listOf(
            Car("winner", maxPosition),
            Car("co-winner", maxPosition),
            Car("loser", minPosition)
        )

        val winners = track.getWinner(cars)

        winners shouldHaveAtLeastSize 1
        winners shouldHaveSize 2
    }
})
