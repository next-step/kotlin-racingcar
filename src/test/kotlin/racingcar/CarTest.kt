package racingcar

import fixture.CarFixture.KIM_CAR
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `자동차를 전진시키면 위치가 한칸 증가한다`() {
        val car = KIM_CAR

        car.forward()

        assertThat(car.position).isEqualTo(1)
    }
}
