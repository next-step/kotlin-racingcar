package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `자동차를 전진시키면 위치가 한칸 증가한다`() {
        val car = Car()

        car.forward()

        assertThat(car.retrievePosition()).isEqualTo(1)
    }
}
