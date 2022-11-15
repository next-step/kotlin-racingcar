package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `자동차의 전진 조건에 만족하여 전진을 하는 경우`() {
        // given
        val car = Car()
        val terms = 4

        // when
        val actual = car.move(terms).position

        // then
        assertThat(actual).isEqualTo(Position(2))
    }

    @Test
    fun `자동차 전진 조건에 만족하지 못하여 제자리에 있는 경우`() {
        // given
        val car = Car()
        val terms = 1

        // when
        val actual = car.move(terms).position

        // then
        assertThat(actual).isEqualTo(Position(1))
    }
}