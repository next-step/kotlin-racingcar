package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racing.domain.Cars.splitNameOfCars

internal class CarsTest {

    @ParameterizedTest
    @CsvSource("1,2,3", "A,B,C,D")
    fun `자동차 이름들로 생성 요청하여 동일한 자동차 수 반환`(nameOfCars: String) {
        val cars = Cars.createCars(splitNameOfCars(nameOfCars))
        assertThat(cars.size).isEqualTo(nameOfCars.split(Cars.NAME_SEPARATOR).size)
    }
}
