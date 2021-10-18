package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `자동차는 위치를 가지고 있다`() {
        val givenPosition = Position(2)
        val car = Car(Name("test"), givenPosition)

        assertThat(car.position).isEqualTo(givenPosition)
    }

    @Test
    fun `자동차의 초기 위치는 0이다`() {
        val car = Car(Name("test"))
        assertThat(car.getPosition()).isEqualTo(0)
    }

    @Test
    fun `자동차의 위치가 0보다 작으면 예외를 던진다`() {
        assertThatCode { Car(Name("test"), Position(-1)) }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `자동차를 앞으로 이동할 수 있다`() {
        // given
        val car = Car(Name("test"), Position(0), FixMoveStrategy())
        // when
        val actual = car.moveForward()
        // then
        assertThat(actual.getPosition()).isEqualTo(1)
    }

    @Test
    fun `자동차 위치와 비교할 위치값을 비교하여 최대값을 리턴한다`() {
        val car = Car(Name("test"), Position(1))

        assertThat(car.findMaxPosition(2)).isEqualTo(2)
    }

    @Test
    fun `자동차 위치와 최대값이 같으면 true를 리턴한다`() {
        val car = Car(Name("test"), Position(5))

        assertThat(car.isMaxPosition(5)).isTrue
    }
}
