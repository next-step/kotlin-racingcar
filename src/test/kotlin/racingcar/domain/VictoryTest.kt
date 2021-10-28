package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class VictoryTest {

    @ParameterizedTest
    @ValueSource(strings = ["pobi,kazu"])
    fun `우승자 차량이 올바르게 나오는지 테스트 한다`(carName: String) {
        val victoryName = "kazu"

        var distance = 0

        val carList: List<Car> = carName.split(",").map {
            distance++
            Car(it, distance)
        }
        val racingCar: RacingCar = RacingCar(carList)

        val victoryCarList: List<Car> = racingCar.victoryCar()

        assertThat(victoryCarList.size).isEqualTo(1)
        assertThat(victoryCarList[0].carName).isEqualTo(victoryName)
    }

    @ParameterizedTest
    @ValueSource(strings = ["pobi,kazu"])
    fun `공동 우승자가 나오는지 테스트 한다`(string: String) {

        val racingCar: RacingCar = RacingCar(string.split(",").map { Car(it) })

        val victoryCarList: List<Car> = racingCar.victoryCar()
        assertThat(victoryCarList.size).isEqualTo(string.split(",").size)
    }
}
