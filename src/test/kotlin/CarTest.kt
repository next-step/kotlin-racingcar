import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun moveTest() {
        val car = Car()
        car.move()
        assertThat(car.distance).isBetween(0, 1)
    }

    @Test
    fun threeTimesMoveTest() {
        val car = Car()
        car.move()
        car.move()
        car.move()
        assertThat(car.distance).isBetween(0, 3)
    }
}
