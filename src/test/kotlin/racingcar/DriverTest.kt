package racingcar

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class DriverTest : DescribeSpec({

    describe("Driver") {
        it("자동차에 이름을 부여할 수 있다.") {
            val car = Car()
            val driver = Driver("papico", car)

            driver.name shouldBe "papico"
        }


        it("drive test") {
            it("인자가 true 면 Car 가 이동한다.") {
                // given
                val car = Car(3)
                val driver = Driver("papico", car)

                // when
                driver.drive(true)

                // then
                driver.driveRecord shouldBe listOf(4)
            }

            it("인자가 false 면 Car 가 이동하지 않는다.") {
                // given
                val car = Car(3)
                val driver = Driver("papico", car)

                // when
                driver.drive(false)

                // then
                driver.driveRecord shouldBe listOf(3)
            }
        }
    }
})
