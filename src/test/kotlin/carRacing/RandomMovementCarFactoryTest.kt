package carRacing

import carRacing.domain.Car
import carRacing.serviceimpl.RandomMovementCarFactory
import carRacing.serviceimpl.RandomMovementController
import carRacing.testcontroller.TestFalseMovementController
import carRacing.testcontroller.TestTrueMovementController
import carRacing.view.CarInfo
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RandomMovementCarFactoryTest {

    private val randomMovementCarFactory: RandomMovementCarFactory = RandomMovementCarFactory()

    @Test
    fun `createCarList로 생성된 모든 Car List는 RandomMovementController를 할당한다`() {
        val car: Car = randomMovementCarFactory.createCarList(listOf("testC")).first()

        assertThat(car.movementController).isInstanceOf(RandomMovementController::class.java)
    }

    @Test
    fun `순서대로 주어진 MovementController 를 주입한 Car 객체를 순서대로 생성한다`() {
        val carInfoList: List<CarInfo> = listOf(
            CarInfo("a", RandomMovementController()),
            CarInfo("b", TestTrueMovementController()),
            CarInfo("c", TestFalseMovementController())
        )

        val result: List<Car> = randomMovementCarFactory.createCars(carInfoList)

        assertAll(
            { assertThat(result).hasSize(3) },
            { assertThat(result[0].movementController).isInstanceOf(RandomMovementController::class.java) },
            { assertThat(result[1].movementController).isInstanceOf(TestTrueMovementController::class.java) },
            { assertThat(result[2].movementController).isInstanceOf(TestFalseMovementController::class.java) }
        )
    }
}
