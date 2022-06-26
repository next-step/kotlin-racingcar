package racingcar.domain.car

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.movingStrategy
import racingcar.domain.notMovingStrategy

class CarsTest : AnnotationSpec() {
    private val movingCars = List(3) {
        Car(
            movingStrategy
        )
    }

    private val notMovingCars = List(3) {
        Car(
            notMovingStrategy
        )
    }

    @Test
    fun `자동차들이 두번씩 움직인다`() {
        // given
        val cars = Cars(movingCars)

        // when
        cars.move()
        cars.move()

        // then
        cars.cars.map { car ->
            car.position.value shouldBe 2
        }
    }

    @Test
    fun `자동차들이 움직이지 않는다`() {
        // given
        val cars = Cars(notMovingCars)

        // when
        cars.move()
        cars.move()

        // then
        cars.cars.map { car ->
            car.position.value shouldBe 0
        }
    }
}
