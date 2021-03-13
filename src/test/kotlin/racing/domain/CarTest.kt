package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.domain.random.TestRandomWrapper

internal class CarTest {

    @Test
    fun moveCar_move() {
        val car = Car("name")
        val movementChecker = MovementChecker(TestRandomWrapper(9))

        assertThat(car.position).isEqualTo(CarPosition.INIT_POSITION)

        val carState = car.moveCarIfPossible(movementChecker)
        assertThat(car.position.value).isEqualTo(1)
        assertThat(carState.position).isEqualTo(CarPosition(1))
        assertThat(carState.name.value).isEqualTo("name")
    }

    @Test
    fun moveCar_notMove() {
        val car = Car("name")
        val movementChecker = MovementChecker(TestRandomWrapper(0))

        assertThat(car.position).isEqualTo(CarPosition.INIT_POSITION)

        val carState = car.moveCarIfPossible(movementChecker)
        assertThat(car.position.value).isEqualTo(0)
        assertThat(carState.position).isEqualTo(CarPosition(0))
        assertThat(carState.name.value).isEqualTo("name")
    }

    @Test
    fun getName() {
        val car = Car("name")
        assertThat(car.name.value).isEqualTo("name")
    }

    @Test
    fun getPosition() {
        val movementChecker = MovementChecker(TestRandomWrapper(9))

        val car = Car("name").apply { moveCarIfPossible(movementChecker) }
        assertThat(car.position.value).isEqualTo(1)
    }
}
