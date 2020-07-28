package step3.racing

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import step3.racing.car.Car
import step3.racing.car.CarImpl

class CarImplTest {

    @Test
    fun `distance 초기값은 0`() {
        assertThat(CarImpl("a").distance).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6])
    fun `move() 횟수 만큼 distance 증가`(number: Int) {
        assertThat(
            CarImpl("a").apply {
                repeat(number) { move() }
            }.distance
        ).isEqualTo(number)
    }

    @ParameterizedTest
    @ValueSource(strings = ["000000", "111111", "asdasdasd"])
    fun `자동차 이름이 5글자 이상이면 Exception`(name: String) {
        assertThatThrownBy {
            CarImpl("$name")
        }.isInstanceOf(Car.NameLengthOverflowException::class.java)
    }
}
