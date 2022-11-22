package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CarTest {

    @Test
    fun `자동차에 이름의 글자수 제한은 한 글자이상 다섯 글자 이하다`() {
        val name = "첫 자동차"
        assertThat(Car(name)).isEqualTo(Car(name = "첫 자동차"))
    }

    @Test
    fun `빈 문자열은 자동차의  이름이 될 수 없다`() {
        val emptyName = ""

        val assertion = assertThrows<IllegalArgumentException> {
            Car(emptyName)
        }

        assertThat(assertion.message).isEqualTo("자동차 이름은 공백, 빈 문자열일 수 없습니다")
    }

    @Test
    fun `5자를 초과하는 문자열은 자동차의 이름이 될 수 없다`() {
        val emptyName = "다섯자이상의 자동차 이름"

        val assertion = assertThrows<IllegalArgumentException> {
            Car(emptyName)
        }

        assertThat(assertion.message).isEqualTo("자동차 이름은 다섯자를 초과할 수 없습니다")
    }

    @Test
    fun `공백은 자동차의 이름이 될 수 없다`() {
        val blankName = " "

        val assertion = assertThrows<IllegalArgumentException> {
            Car(blankName)
        }

        assertThat(assertion.message).isEqualTo("자동차 이름은 공백, 빈 문자열일 수 없습니다")
    }

    @Test
    fun `자동차를 기본 인자로 생성하면 위치의 값은 0이다`() {
        val name = "자동차"
        assertThat(Car(name)).isEqualTo(Car(name = "자동차", _position = 0))
    }

    @Test
    fun `position 을 통해 현재 자동차의 위치를 알 수 있다`() {
        val car = Car("자동차")
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `canMove 를 통해 받아오는 movable 의 값이 true 인 경우 전진한다`() {
        val name = "자동차"
        val car = Car(name)
        car.move(true)
        assertThat(Car(name)).isEqualTo(Car(name = "자동차", _position = 0))
    }

    @Test
    fun `canMove 를 통해 받아오는 movable 의 값이 false 인 경우 멈춘다`() {
        val name = "자동차"
        val car = Car(name)
        car.move(false)
        assertThat(car).isEqualTo(Car(name = "자동차", _position = 0))
    }
}
