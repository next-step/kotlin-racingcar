package racingCar

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RaceTest : DescribeSpec({
    describe("run") {
        it("tryCount * carCount 만큼 moveFor 을 호출한다.") {
            val race = Race(3, 2)

            race.run()

            race.carPositions.size shouldBe 6
        }
    }
})
