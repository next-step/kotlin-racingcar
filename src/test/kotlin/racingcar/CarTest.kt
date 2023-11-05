package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarTest {
    @Test
    fun `자동차의 이름은 1자 이상이어야 한다`() {
        assertThrows<IllegalArgumentException> { Car("") }
    }

    @Test
    fun `자동차의 이름은 5자 이하여야 한다`() {
        assertThrows<IllegalArgumentException> { Car("123456") }
    }

    @Test
    fun `자동차는 4 이상이 들어오면 움직인다`() {
        val car = Car("name")
        val result = car.move(4)
        assertThat(result.position).isOne()
    }

    @Test
    fun `자동차는 4 미만이 들어오면 움직이지 않는다`() {
        val car = Car("name")
        val result = car.move(3)
        assertThat(result.position).isZero()
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 10])
    fun `자동차는 0 이상 9 이하의 값만 가능하다`(power: Int) {
        val car = Car("name")

        assertThrows<IllegalArgumentException> {
            car.move(power)
        }
    }
}
