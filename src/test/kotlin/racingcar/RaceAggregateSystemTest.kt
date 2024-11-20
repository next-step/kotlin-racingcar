package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RaceAggregateSystemTest : StringSpec({
    "Car 객체가 담긴 리스트가 비어있으면 예외를 반환한다." {
        shouldThrow<IllegalArgumentException> {
            RaceAggregateSystem(listOf())
        }
    }

    "경주 결과를 기록할 때 진행중이라면 우승자는 기록되지 않는다." {
        val cars =
            listOf(
                Car("test1", moveCount = 1),
                Car("test2", moveCount = 2),
                Car("test3", moveCount = 3),
            )
        val raceAggregateSystem = RaceAggregateSystem(cars)
        raceAggregateSystem.recordPhaseResult(1, cars)

        raceAggregateSystem.winners shouldBe emptyList()
    }

    "경주 결과를 기록할 때 마지막 회차라면 우승자도 함께 기록한다." {
        val cars =
            listOf(
                Car("test1", moveCount = 1),
                Car("test2", moveCount = 2),
                Car("test3", moveCount = 3),
            )
        val raceAggregateSystem = RaceAggregateSystem(cars)
        raceAggregateSystem.recordPhaseResult(0, cars)

        raceAggregateSystem.winners[0] shouldBe "test3"
    }

    "경주의 최종 우승자를 기록할 수 있다." {
        val cars =
            listOf(
                Car("test1", moveCount = 1),
                Car("test2", moveCount = 2),
                Car("test3", moveCount = 3),
            )
        val raceAggregateSystem = RaceAggregateSystem(cars)
        raceAggregateSystem.recordPhaseResult(0, cars)

        raceAggregateSystem.winners[0] shouldBe "test3"
    }

    "경주의 최종 우승자가 여러명이라면 모두 기록한다." {
        val cars =
            listOf(
                Car("test1", moveCount = 1),
                Car("test2", moveCount = 1),
                Car("test3", moveCount = 1),
            )
        val raceAggregateSystem = RaceAggregateSystem(cars)
        raceAggregateSystem.recordPhaseResult(0, cars)

        raceAggregateSystem.winners shouldBe listOf("test1", "test2", "test3")
    }
})
