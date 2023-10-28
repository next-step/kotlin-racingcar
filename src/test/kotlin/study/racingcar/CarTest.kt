package study.racingcar

import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `car moves if random value is 4 or more`() {
        val car = Car()
        car.move(4)
        assertThat(car.position).isEqualTo(1)
        car.move(5)
        assertThat(car.position).isEqualTo(2)
    }

    @Test
    fun `car stays if random value is less than 4`() {
        val car = Car()
        car.move(3)
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `display position`() {
        val car = Car(3)
        assertThat(car.displayPosition()).isEqualTo("---")
    }
}
