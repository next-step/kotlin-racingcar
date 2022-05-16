package step3.racing

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CarTest : DescribeSpec({
    describe("run") {
        it("isMoved 값이 true 일 때 거리가 1 증가한다.") {
            val car = Car()
            val isMoved = true

            car.run(isMoved)

            car.distance shouldBe 1
        }

        it("isMoved 값이 false 일 때 거리가 증가하지 않는다.") {
            val car = Car()
            val isMoved = false

            car.run(isMoved)

            car.distance shouldBe 0
        }
    }
})
