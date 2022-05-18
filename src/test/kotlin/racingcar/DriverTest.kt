package racingcar

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class DriverTest : DescribeSpec({

    describe("Driver") {
        it("drive test") {
            it("인자가 true 면 Car 가 이동한다.") {
                // given
                val car = Car(3)
                val driver = Driver(car)

                // when
                driver.drive(true)

                // then
                driver.driveRecord shouldBe listOf(4)
            }

            it("인자가 false 면 Car 가 이동하지 않는다.") {
                // given
                val car = Car(3)
                val driver = Driver(car)

                // when
                driver.drive(false)

                // then
                driver.driveRecord shouldBe listOf(3)
            }
        }
    }
})
