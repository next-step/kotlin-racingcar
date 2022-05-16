package racingcar

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class DriverTest : DescribeSpec({

    describe("Driver") {
        it("인자에 따라 drive 함수를 실행한다.") {
            // given
            val car = Car(3)
            val driver = Driver(car)

            // when
            driver.drive(true)

            // then
            driver.driveRecord shouldBe listOf(4)
        }
    }
})
