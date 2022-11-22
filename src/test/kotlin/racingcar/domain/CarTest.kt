package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CarTest {

    @Test
    fun `자동차의 전진 조건인 랜덤 숫자 4이상이 되어 만족하여 전진을 하는 경우`() {
        // given
        val car = Car("")
        val terms = 4

        // when
        val actual = car.move(terms).position

        // then
        assertThat(actual).isEqualTo(Position(2))
    }

    @Test
    fun `자동차 전진 조건에 만족하지 못한 랜덤 숫자가 4미만이라 제자리에 있는 경우`() {
        // given
        val car = Car("")
        val terms = 1

        // when
        val actual = car.move(terms).position

        // then
        assertThat(actual).isEqualTo(Position(1))
    }

    @Test
    fun `자동차 이름이 5글자가 넘어 자동차 생성 실패`() {
        assertThrows<IllegalArgumentException> {
            Car("123456")
        }
    }
}