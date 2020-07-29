package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `increase distance when flag is between 4 and 9`() {
        val car = Car("a")
        car.run(flag = 4)
        car.run(flag = 9)
        assertThat(car.distance).isEqualTo(2)
    }

    @Test
    fun `no change in distance when flag is between 0 and 3`() {
        val car = Car("b")
        car.run(flag = 0)
        car.run(flag = 3)
        assertThat(car.distance).isEqualTo(0)
    }

    // TODO random값(flag) 관련 isRunnable TEST 필요
}
