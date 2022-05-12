package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `자동차 객체 동등성 비교`() {
        val car1 = Car(1)
        val car2 = Car(1)

        assertThat(car1).isEqualTo(car2)
    }
}
