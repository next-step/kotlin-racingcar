package racingCar

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RaceTest : DescribeSpec({
    describe("run") {
        it("carCount 만큼 move 을 호출한다.") {
            val carCount = 3
            val race = Race(carCount)

            race.run()

            race.result.size shouldBe carCount
        }
    }
})
