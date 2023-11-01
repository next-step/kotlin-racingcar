package racingCar.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import racingCar.helper.CarFixture

class CarsTest : DescribeSpec({

    describe("move") {
        val cars = Cars(
            cars = CarFixture.makeCars(2),
            numberGenerator = CarFixture.makeFakeCarPowerGenerator(4)
        )

        context("모든 차들에 대해서 엔진을 주입하면") {
            cars.move()

            it("차의 위치는 변한다.") {
                cars.cars.map { it.position } shouldBe listOf(CarPosition(2), CarPosition(2))
            }
        }
    }
})
