import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTests {
    @Test
    fun `diceMoveAddStep`() {
        val car = Car()
        var previousStepCount = car.stepList.size
        car.diceMove()
        assertThat(previousStepCount + 1).isEqualTo(car.stepList.size)
    }
}
