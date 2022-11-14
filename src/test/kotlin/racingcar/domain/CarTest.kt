package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `자동차의 전진을 하여 위치가 변동되는 지 확인`() {
        // given
        var car = Car()

        // when
        val actual = car.move().position

        // then
        assertThat(actual).isEqualTo(Position(2))
    }

    @Test
    fun `자동차가 여러번 전진을 했을 때 위치가 변동되는 지 확인`() {
        // given
        var car = Car()

        // when
        val actual = car.move().move().move().move().position

        // then
        assertThat(actual).isEqualTo(Position(5))
    }
}