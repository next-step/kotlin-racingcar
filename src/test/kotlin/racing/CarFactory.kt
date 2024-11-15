package racing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarFactoryTest : StringSpec({
    beforeTest {
        CarFactory.resetSequence()
    }

    "자동차를 생성할 수 있다" {
        val car = CarFactory.createCar()

        car.getPosition() shouldBe 0
    }

    "자동차를 생성할 때마다 부여되는 sequence가 증가한다" {
        val car1 = CarFactory.createCar()
        val car2 = CarFactory.createCar()

        car1.getSequence() shouldBe 0
        car2.getSequence() shouldBe 1
    }
})

object CarFactory {
    private var sequence: Int = 0

    fun createCar(position: Int = 0): Car {
        return Car.from(sequence++, position)
    }

    fun resetSequence() {
        sequence = 0
    }
}
