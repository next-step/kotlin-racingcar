package racingcar

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class DriverTest : DescribeSpec({

    describe("Driver") {
        it("drive 함수 테스트") {
            // given
            val car = Car(3)
            val driver = Driver(car)

            // when
            driver.drive(true)

            // then
            car.movement shouldBe 4
        }

        it("getMoveResult") {
            // given
            val driver = Driver(Car(3))

            // then
            driver.getMoveResult() shouldBe "---"

        }
    }
})
