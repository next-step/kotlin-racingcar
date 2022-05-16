package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.random.Random

class CarTest {
    @Test
    fun `자동차의 처음 이동거리는 0이다`() {
        // given
        val car = Car()

        // then
        assertThat(car.distance).isEqualTo(0)
    }

    @Test
    fun `4 미만의 숫자를 전달받을 경우 이동 거리는 늘어나지 않는다`() {
        // given
        val car = Car()

        // when
        car.moveRandom(Random.nextInt(3))

        // then
        assertThat(car.distance).isEqualTo(0)
    }

    @Test
    fun `4 이상의 숫자를 전달받을 경우 이동 거리가 1 늘어난다`() {
        // given
        val car = Car()

        // when
        car.moveRandom(Random.nextInt(4, Int.MAX_VALUE))

        // then
        assertThat(car.distance).isEqualTo(1)
    }
}
