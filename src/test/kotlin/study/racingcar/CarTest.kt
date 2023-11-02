package study.racingcar

import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `car moves if random value is 4 or more`() {
        val car = Car()
        var movedCar = car.move(4)
        assertThat(movedCar.position).isEqualTo(1)

        movedCar = movedCar.move(5)
        assertThat(movedCar.position).isEqualTo(2)
    }

    @Test
    fun `car stays if random value is less than 4`() {
        val car = Car()
        val movedCar = car.move(3)
        assertThat(movedCar.position).isEqualTo(0)
    }
}
