package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarTest {

    @Test
    fun `자동차는 움직입니다`() {
        val car = Car()

        car.moveByStrategy { true }

        assertThat(car).isEqualTo(Car.from(1))
    }

    @ParameterizedTest
    @CsvSource(value = ["0=true", "1=false"], delimiter = '=')
    fun `동일한 위치여부를 판단합니다`(input: Int, expectedResult: Boolean) {
        val car = Car()

        val result = car.isSamePosition(Car.from(input))

        assertThat(result).isEqualTo(expectedResult)
    }
}
