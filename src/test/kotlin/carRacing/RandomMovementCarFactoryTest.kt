package carRacing

import carRacing.domain.Car
import carRacing.serviceimpl.RandomMovementCarFactory
import carRacing.serviceimpl.RandomMovementController
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomMovementCarFactoryTest {

    private val randomMovementCarFactory: RandomMovementCarFactory = RandomMovementCarFactory()

    @Test
    fun `createCarList로 생성된 모든 Car List는 RandomMovementController를 할당한다`() {
        val car: Car = randomMovementCarFactory.createCarList(listOf("testC")).first()

        assertThat(car.movementController).isInstanceOf(RandomMovementController::class.java)
    }
}
