package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun is_go() {
        val car = Car()

        val result = car.isGo(4)

        assertThat(result).isTrue()
    }

    @Test
    fun is_not_go() {
        val car = Car()

        val result = car.isGo(3)

        assertThat(result).isFalse()
    }
}
