package racingcar.domain.car

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.util.Validation

class CarsTest {
    @ParameterizedTest
    @ValueSource(strings = ["jung"])
    fun `자동차에 이름을 입력할 수 있다`(input: String) {
        val cars = Cars(input)
        val carName = cars.carList[0].name
        Assertions.assertEquals(input, carName)
    }

    @ParameterizedTest
    @ValueSource(strings = ["jung,sang"])
    fun `자동차 이름은 쉼표(,)를 기준으로 구분한다`(input: String) {
        val carNameList = input.split(Validation.DELIMITER)
        val cars = Cars(input)
        val carName = cars.carList[0].name
        val carName2 = cars.carList[1].name
        Assertions.assertEquals(carNameList[0], carName)
        Assertions.assertEquals(carNameList[1], carName2)
    }
}
