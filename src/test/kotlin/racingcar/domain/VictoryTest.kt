package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class VictoryTest {

    @ParameterizedTest
    @ValueSource(strings = ["pobi,kazu"])
    fun `우승자 차량이 올바르게 나오는지 테스트 한다`(string: String) {

        val resultName = "kazu"

        val carList: List<Car> = CarFactory.createCars(string.split(","))

        for (car in carList) {
            if (car.carName == resultName) {
                car.distance += 1
            }
        }

        val victoryCarList: List<Car> = Victory.victoryCar(carList)
        assertThat(victoryCarList[0].carName).isEqualTo(resultName)
    }
}
