package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

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
}
