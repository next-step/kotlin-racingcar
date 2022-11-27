package racingcar.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

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
    }
})
