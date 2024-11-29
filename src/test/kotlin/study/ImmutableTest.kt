package study

import io.kotest.core.spec.style.DescribeSpec
import racingcars.domain.Car

class ImmutableTest : DescribeSpec({
    describe("immutable") {
        it("carList") {
            val carList = listOf(Car(id = 1, _position = 5, name = "car"))
            val car = carList.first()

            // compile error
//            car.position = 10
        }
    }
})
