package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.exception.CannotFindWinnerException

class RaceResultTest : DescribeSpec({
    describe("레이싱 자동차 게임 결과") {
        it("마지막 라운드의 단일 우승자를 찾을 수 있다.") {
            val firstRoundHistory = RoundHistory(1, listOf(Pair("pobi", 1), Pair("crong", 1)))
            val secondRoundHistory = RoundHistory(1, listOf(Pair("pobi", 2), Pair("crong", 1)))

            val roundHistories = listOf(firstRoundHistory, secondRoundHistory)
            val raceResult = RaceResult(roundHistories)

            raceResult.getWinners() shouldBe listOf("pobi")
        }

        it("마지막 라운드의 복수 우승자를 찾을 수 있다.") {
            val firstRoundHistory = RoundHistory(1, listOf(Pair("pobi", 1), Pair("crong", 1)))
            val secondRoundHistory = RoundHistory(1, listOf(Pair("pobi", 2), Pair("crong", 2)))

            val roundHistories = listOf(firstRoundHistory, secondRoundHistory)
            val raceResult = RaceResult(roundHistories)

            raceResult.getWinners() shouldBe listOf("pobi", "crong")
        }

        it("라운드 결과가 없을 경우 우승자를 찾을 수 없다.") {
            val roundHistory = RoundHistory(1, listOf())

            val roundHistories = listOf(roundHistory)
            val raceResult = RaceResult(roundHistories)

            shouldThrow<CannotFindWinnerException> {
                raceResult.getWinners()
            }
        }
    }
})
