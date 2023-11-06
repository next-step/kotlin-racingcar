package carRacing

import carRacing.domain.Car
import carRacing.serviceimpl.RandomMovementCarFactory
import carRacing.serviceimpl.RandomMovementController
import carRacing.view.CarInfo
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomMovementCarFactoryTest {

    private val randomMovementCarFactory: RandomMovementCarFactory = RandomMovementCarFactory()

    @Test
    fun `MovementController가 주어지지 않았을 경우, RandomMovementController를 할당한다`() {
        val carInfo: CarInfo = CarInfo("testC")

        val car: Car = randomMovementCarFactory.createCars(listOf(carInfo)).first()

        assertThat(car.movementController).isInstanceOf(RandomMovementController::class.java)
    }
}
