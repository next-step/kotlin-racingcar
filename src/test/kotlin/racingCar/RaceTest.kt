package racingCar

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RaceTest : DescribeSpec({
    describe("run") {
        it("carCount 만큼 moveFor 을 실행한다.") {
            val race = Race(3, 1)

            race.run()

            race.carPositions.size shouldBe 3
        }
    }
})