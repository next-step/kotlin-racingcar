package racinggame.spec

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import racinggame.car.V8Engine

internal class CarFactoryTest {

    @Test
    fun `입력을 자동차로 변경한다`() {
        // given
        val carRequest = CarFactory("pobi,crong,honux")

        // when
        val list = carRequest.toRacingCar(V8Engine())

        // then
        assertThat(list).hasSize(3)
    }

    @Test
    fun `공백 입력시 exception`() {
        // given

        // when

        // then
        assertThatThrownBy { CarFactory("") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("경주할 자동차 이름이 없습니다.")
    }
}
