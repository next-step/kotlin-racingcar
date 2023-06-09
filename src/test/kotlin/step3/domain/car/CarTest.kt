package step3.domain.car

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import step3.domain.formula.NotMoveFormula

class CarTest : DescribeSpec({

    describe(name = "자동차를 생성할 때") {
        val position = 3

        context(name = "위치를 명시적으로 지정하면") {
            val car = CarFactory.createCar(position = position)

            it(name = "지정한 위치로 생성된다.") {
                car.move(moveFormula = NotMoveFormula) shouldBe position
            }
        }
    }

    describe(name = "자동차들을 생성할 때") {
        val count = 3

        context(name = "개수를 명시적으로 지정하면") {
            val cars = CarFactory.createCars(count = count)

            it(name = "지정한 개수만큼 생성된다.") {
                cars.size shouldBe count
            }
        }
    }
})
