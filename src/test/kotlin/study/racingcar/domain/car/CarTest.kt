package study.racingcar.domain.car

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest {
    @Test
    fun `power 값이 4 이상일 때만 전진할 수 있다`() {
        val car = Car(" ")
        val power = Power(4)
        car.move(power)
        assertThat(car.currentLocation).isEqualTo(2)
    }

    @Test
    fun `power 값이 4 미만이면 전진하지 않는다`() {
        val car = Car(" ")
        val power = Power(3)
        car.move(power)
        assertThat(car.currentLocation).isNotEqualTo(2)
    }

    @Test
    fun `Car는 이름을 가질 수 있다`() {
        val car = Car("원준")
        assertThat(car.name).isEqualTo("원준")
    }

    @Test
    fun `Cars 사이에서 승자임을 알 수 있다`() {
        val cars = listOf(Car("그렌저"), Car("소나타"), Car("제네시스"))
        cars[0].move(Power(4))
        cars[0].move(Power(4))

        assertThat(cars[0].isWin(cars)).isTrue
        assertThat(cars[1].isWin(cars)).isFalse
        assertThat(cars[2].isWin(cars)).isFalse
    }

    @Test
    fun `Car의 이름은 다섯자를 초과할 수 없다`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                Car("일이삼사오육")
            }.withMessageMatching("자동차의 이름은 5자를 초과할 수 없습니다.")

        Assertions.assertThatNoException().isThrownBy {
            Car("이름다섯자")
        }
    }
}
