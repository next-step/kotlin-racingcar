package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveAtLeastSize
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

internal class RankTest : StringSpec({

    "우승자를 선출한다." {
        val maxPosition = 10
        val minPosition = 0
        val cars = listOf(
            Car("win", maxPosition),
            Car("loser", minPosition)
        )

        val winners: List<String> = Rank.getWinnerNames(cars)

        winners shouldHaveSize 1
        winners.first() shouldBe "win"
    }

    "우승자는 1명 이상일 수 있다." {
        val maxPosition = 10
        val minPosition = 0
        val cars = listOf(
            Car("win", maxPosition),
            Car("co-w", maxPosition),
            Car("loser", minPosition)
        )

        val winners: List<String> = Rank.getWinnerNames(cars)

        winners shouldHaveAtLeastSize 1
        winners shouldHaveSize 2
    }
})
