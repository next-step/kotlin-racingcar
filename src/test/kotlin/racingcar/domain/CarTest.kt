package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.vo.Position

class CarTest {
    @Test
    fun `자동차 생성`() {
        val car = Car()

        assertThat(car.position.value).isEqualTo(0)
    }

    @Test
    fun `자동차 전진`() {
        val position = Position()
        val car = Car(position)

        car.move { true }
        assertThat(car.position.value).isGreaterThan(position.value)
    }

    @Test
    fun `자동차 전진하지 않음`() {
        val position = Position()
        val car = Car(position)

        car.move { false }
        assertThat(car.position.value).isEqualTo(position.value)
    }
}
