package racingcar

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CarTest : DescribeSpec({

    describe("Car") {
        it("move 함수 실행 시 movement 가 증가한다.") {
            // given
            val car = Car()

            // when
            car.move()

            // then
            car.movement shouldBe 1
        }
    }
})
