package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차 이름을 입력받고, 자동차 객체 생성 시 이름이 5자를 초과할 때, 예외를 던진다`() {
        // given : 자동차 이름을 입력받는다.
        val name = "oyjoyj"
        val position = 0

        // when : 자동차 객체 생성 시 이름이 5자를 초과할 때
        val actual = runCatching { Car(name = name, _position = position) }.exceptionOrNull()

        // then : 예외를 던진다
        assertThat(actual).isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `,자동차 전진 요청 시, position이 1 증가한다`() {
        // given :
        val name = "oyj"
        val position = 0
        val car = Car(name = name, _position = position)

        // when : 자동차 전진 요청(기본 위치는 0)
        car.move()
        car.move()
        val actual = car.position

        // then : 위치가 1 증가한다.
        assertThat(actual).isEqualTo(2)
    }
}
