package game.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("경주용 자동차")
internal class CarTest {

    @Test
    fun `처음 위치는 0`() {
        // given
        val car = Car()
        val expected = 0

        // when
        // then
        assertThat(car.position).isEqualTo(expected)
    }

    @Test
    fun `움직인 횟수에 따른 위치`() {
        // given
        val car = Car()
        val expected = 10

        // when
        for (i in 1..expected) {
            car.move()
        }

        // then
        assertThat(car.position).isEqualTo(expected)
    }
}
