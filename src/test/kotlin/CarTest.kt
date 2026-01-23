import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun 자동차를_만든다() {
        val car = Car(position = 0)
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun 자동차를_위치_초기값을_추가하여_만든다() {
        val car = Car(position = 1)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun 자동차는_전진한다() {
        val car = Car(position = 0)
        car.move()
        assertThat(car.position).isEqualTo(1)
    }
}
