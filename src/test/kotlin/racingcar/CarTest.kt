package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    internal fun `랜덤값이 4이상일 때 전진이 나온다`() {
        val car = Car()
        car.move(4)
        assertThat(car.score).isEqualTo(1)
    }

    @Test
    internal fun `랜덤값이 4이상일 때는 전진하지 않는다`() {
        val car = Car()
        car.move(3)
        assertThat(car.score).isEqualTo(0)
    }
}
