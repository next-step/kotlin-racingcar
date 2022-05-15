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
            car.movement shouldBe 4
        }

        it("getMoveResult 실행 시 현재 진행상태를 반환한다.") {
            // given
            val driver = Driver(Car(3))

            // then
            driver.getMoveResult() shouldBe "---"

        }
    }
})
