package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `자동차가 앞으로 전진한다`() {
        val car = Car("eunseok")
        car.movePosition()

        assertThat(car.position).isEqualTo(1)
    }
}
