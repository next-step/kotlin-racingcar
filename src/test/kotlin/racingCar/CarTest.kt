package racingCar

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CarTest : DescribeSpec({
    describe("moveFor") {
        it("position 을 1만큼 증가시킨다.") {
            // given
            val car = Car()

            // when
            car.moveFor(5)

            // then
            car.position shouldBe 1
        }

        context("랜덤으로 생성한 숫자가 4 미만일 때") {
            it("position 은 증가시키지 않는다.") {
                // given
                val car = Car()

                // when
                car.moveFor(3)

                // then
                car.position shouldBe 0
            }
        }
    }
})
