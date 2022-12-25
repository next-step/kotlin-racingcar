package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RaceResultTest : DescribeSpec({
    describe("레이스 결과 테스트") {
        it("경주 히스토리가 없으면 결과를 도출할 수 없다.") {
            var roundHistories = listOf<RoundHistory>()

            shouldThrow<IllegalArgumentException> {
                RaceResult(roundHistories)
            }
        }

        it("최종 승자를 알 수 있다.") {
            val firstCar = Car("자동차1", 1)
            val secondCar = Car("자동차2", 2)
            val cars = Cars(listOf(firstCar, secondCar))

            val raceResult = RaceResult(
                listOf(RoundHistory(1, cars))
            )

            raceResult.getFinalRoundWinners() shouldBe listOf(secondCar)
        }
    }
})
