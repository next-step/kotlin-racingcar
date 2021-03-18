package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CarTest {

    @Test
    internal fun `history에 CarAction이 잘 쌓이는지 테스트`() {
        val car = Car("test")
        car.move()
        assertThat(car.history).isEqualTo(listOf(CarAction.MOVE))
        car.stop()
        assertThat(car.history).isEqualTo(listOf(CarAction.MOVE, CarAction.STOP))
    }

    @Test
    internal fun `각 자동차에 이름을 부여할 수 있다`() {
        val car = Car("김수현")
        assertThat(car.name).isEqualTo("김수현")
    }

    @Test
    internal fun `이름은 5글자를 초과할 수 없다`() {
        assertThrows<IllegalArgumentException> { Car("가나다라마바") }
    }

    @Test
    internal fun `자동차는 포지션이 있어야한다`() {
        val car = Car("test")
        car.move()
        car.stop()
        car.move()
        assertThat(car.currentPosition(1)).isEqualTo(1)
        assertThat(car.currentPosition(2)).isEqualTo(1)
        assertThat(car.currentPosition(3)).isEqualTo(2)
    }
}
