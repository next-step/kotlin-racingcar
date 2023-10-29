package racingcar.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import racingcar.helper.CarFixture

class CarsTest : DescribeSpec({

    describe("move") {
        val cars = Cars(
            cars = CarFixture.makeCars(2),
            numberGenerator = CarFixture.makeFakeCarPowerGenerator(4)
        )

        context("모든 차들에 대해서 엔진을 주입하면") {
            cars.move()

            it("차의 위치는 변한다.") {
                cars.getPositions() shouldBe listOf(CarPosition(2), CarPosition(2))
            }
        }
    }

    describe("getPositions") {
        val cars = Cars(
            cars = CarFixture.makeCars(2),
            numberGenerator = CarFixture.makeFakeCarPowerGenerator(1)
        )

        context("모든 차들의 위치를 가져오면") {
            it("차의 위치를 반환한다.") {
                cars.getPositions() shouldBe listOf(CarPosition(1), CarPosition(1))
            }
        }
    }
})
