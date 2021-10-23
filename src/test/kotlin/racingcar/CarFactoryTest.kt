package racingcar

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.car.CarFactory

class CarFactoryTest {
    @ParameterizedTest
    @CsvSource("1, 1", "2, 2", "3, 3")
    fun `입력받은 자동차 개수 만큼 자동차가 생성된다`(input: Int, expected: Int) {
        val cars = CarFactory.create(input)
        val carListSize = cars.getCarList().size
        Assertions.assertEquals(carListSize, expected)
    }
}
