package study.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import study.racingcar.domain.Car
import java.lang.IllegalArgumentException

internal class CarTest {

    @ParameterizedTest
    @ValueSource(strings = ["a", "bb", "ccc", "dddd", "eeeee"])
    fun `Car는 name을 가질 수 있다`(name: String) {
        val car = Car(name)

        assertThat(car.name).isEqualTo(name)
    }

    @Test
    fun `name은 5글자을 초과할 수 없다`() {
        val name = "abcdef"

        assertThrows<IllegalArgumentException> {
            Car(name)
        }
    }

    @Test
    fun `Car 초기 값 테스트`() {
        val car = Car("name")

        assertThat(car.position).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `condition이 4 이상일 때 움직인다`(condition: Int) {
        val car = Car("name")

        car.move(condition)

        assertThat(car.position).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `condition이 4 이하일 때 움직이지 않는다`(condition: Int) {
        val car = Car("name")

        car.move(condition)

        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `Car를 copy할 수 있다`() {
        val car = Car("name")

        val newCar = car.copy()

        assertThat(newCar.name).isEqualTo("name")
        assertThat(newCar.position).isEqualTo(0)

        car.move(5)

        assertThat(car.position).isEqualTo(1)
        assertThat(newCar.position).isEqualTo(0)
    }
}
