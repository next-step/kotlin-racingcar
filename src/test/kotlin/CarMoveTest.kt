import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarMoveTest {
    /**
     * Environment variables OPERATE_MODE = "test"로 설정해주세요
     */
    @Test
    fun carMoveTest() {
        val car = Car()
        car.move()
        assertThat(car.getDistance()).isEqualTo(1)
    }
}
