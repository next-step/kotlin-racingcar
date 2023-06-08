package step3.domain.car

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CarTest : DescribeSpec({

    describe(name = "자동차를 생성할 때") {
        context(name = "위치를 명시적으로 지정하면") {
            val createCar = CarFactory.createCar(position = 3)

            it(name = "지정한 위치로 생성된다.") {
                createCar.move(value = 3) shouldBe 3
            }
        }
    }
})
