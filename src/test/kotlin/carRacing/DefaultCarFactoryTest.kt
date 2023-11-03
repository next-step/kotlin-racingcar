package carRacing

import carRacing.domain.Car
import carRacing.serviceimpl.DefaultCarFactory
import carRacing.serviceimpl.RandomMovementController
import carRacing.testcontroller.TestFalseMovementController
import carRacing.testcontroller.TestTrueMovementController
import carRacing.view.CarInfo
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class DefaultCarFactoryTest {

    private val defaultCarFactory: DefaultCarFactory = DefaultCarFactory()

    @Test
    fun `구현되지 않은 createCars 호출 시 NotImplementedError 이 발생한다`() {
        assertThrows<NotImplementedError> {
            defaultCarFactory.createCars(1)
        }
    }

    @Test
    fun `순서대로 주어진 MovementController 를 주입한 Car 객체를 순서대로 생성한다`() {
        val carInfoList: List<CarInfo> = listOf(
            CarInfo("a", RandomMovementController()),
            CarInfo("b", TestTrueMovementController()),
            CarInfo("c", TestFalseMovementController())
        )

        val result: List<Car> = defaultCarFactory.createCars(carInfoList)

        assertAll(
            { assertThat(result).hasSize(3) },
            { assertThat(result[0].movementController).isInstanceOf(RandomMovementController::class.java) },
            { assertThat(result[1].movementController).isInstanceOf(TestTrueMovementController::class.java) },
            { assertThat(result[2].movementController).isInstanceOf(TestFalseMovementController::class.java) }
        )
    }
}
