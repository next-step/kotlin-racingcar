package step3.racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import step3.racing.domain.Car
import step3.racing.domain.RaceHistory
import step3.racing.domain.Round

class RaceHistoryTest : DescribeSpec({
    describe("push") {
        it("push 하면 history 가 쌓인다.") {
            val raceHistory = RaceHistory(1)

            raceHistory.push(Round(listOf(Car("name"))))

            raceHistory.getAllHistory().size shouldBe 1
        }
    }

    describe("getAllHistory") {
        it("round 만큼 히스토리가 쌓이지 않으면 ~ 던진다.") {
            val raceHistory = RaceHistory(10)

            val exception = shouldThrow<IllegalStateException> { raceHistory.getAllHistory() }

            exception.message shouldBe "모든 히스토리가 완성되지 않았습니다."
        }

        it("round 만큼 히스토리가 쌓인다면 모든 히스토리를 반환한다.") {
            val car = Car("name")
            val raceHistory = RaceHistory(1)

            raceHistory.push(Round(listOf(car)))

            val allHistory = raceHistory.getAllHistory()
            allHistory.size shouldBe 1
            allHistory[0].cars[0].name shouldBe "name"
            allHistory[0].cars[0].distance shouldBe 0
        }
    }
})
