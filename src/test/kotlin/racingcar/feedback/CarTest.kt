package racingcar.feedback

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차를 생성한다`() {
        val car = Car("jason", 0)
        assertThat(car.name).isEqualTo("jason")
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `기본 인자를 활용하여 자동차를 생성한다`() {
        val car = Car("jason")
        assertThat(car.name).isEqualTo("jason")
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `자동차의 이름이 5글자를 초과하면 오류를 발생시킨다`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Car("가나다라마바사")
        }
    }

    @Test
    fun `팩토리 함수를 이용하여 자동차를 생성한다`() {
        val car = Car.of("jason")
        assertThat(car.name).isEqualTo("jason")
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `정적 변수를 사용한다`() {
        val car = Car.DEFAULT_CAR
        assertThat(car.name).isEqualTo("")
        assertThat(car.position).isEqualTo(0)
    }
}
