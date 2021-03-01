package racinggame.spec

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racinggame.car.V8Engine

internal class CarRequestTest {

    @Test
    fun `입력을 자동차로 변경한다`() {
        // given
        val carRequest = CarRequest(2)

        // when
        val list = carRequest.toRacingCar(V8Engine())

        // then
        assertThat(list).hasSize(2)
    }
}
