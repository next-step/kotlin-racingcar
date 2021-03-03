package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    internal fun `history에 CarAction이 잘 쌓이는지 테스트`() {
        val car = Car()
        car.move()
        assertThat(car.history).isEqualTo(listOf(CarAction.MOVE))
        car.stop()
        assertThat(car.history).isEqualTo(listOf(CarAction.MOVE, CarAction.STOP))
    }
}
