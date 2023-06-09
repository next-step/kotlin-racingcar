package study.racingcar.race

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly

class RaceSummaryTest : StringSpec({
    "우승자는 position 이 가장 높은 자동차이다." {
        val carStates1 = listOf(
            CarState("car1", 4),
            CarState("car2", 2),
            CarState("car3", 3)
        )
        val carStates2 = listOf(
            CarState("car1", 5),
            CarState("car2", 3),
            CarState("car3", 4)
        )

        val raceResults = listOf(
            RaceResult(carStates1),
            RaceResult(carStates2)
        )

        val raceSummary = RaceSummary(raceResults)

        val winners = raceSummary.determineWinners()

        winners.shouldContainExactly("car1")
    }

    "position 이 최대인 자동차가 여러대이면 우승자도 한 대 이상이다." {
        val carStates1 = listOf(
            CarState("car1", 4),
            CarState("car2", 2),
            CarState("car3", 4)
        )
        val carStates2 = listOf(
            CarState("car1", 5),
            CarState("car2", 3),
            CarState("car3", 5)
        )

        val raceResults = listOf(
            RaceResult(carStates1),
            RaceResult(carStates2)
        )

        val raceSummary = RaceSummary(raceResults)

        val winners = raceSummary.determineWinners()

        winners.shouldContainExactly("car1", "car3")
    }
})
