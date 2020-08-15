package onestep.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarsTest {

    @DisplayName(value = "FindWinner 의 경우, position이 가장 큰 Car가 리턴되어야한다.")
    @Test
    fun checkCarsFindWinnerTest() {
        val list = listOf(
            Car(name = "car1", _position = 10),
            Car(name = "car2", _position = 3)
        )
        val cars = Cars(list)

        assertThat(cars.findWinners().toCarNameList()).contains("car1")
    }

    @DisplayName(value = "position이 같은 꼉우 FindWinner의 결과가 모두 리턴되어야한다.")
    @Test
    fun checkCarsFindWinnersTest() {
        val list = listOf(Car(name = "car1", _position = 3), Car(name = "car2", _position = 3))
        val cars = Cars(list)

        assertThat(cars.findWinners().toCarNameList().size).isEqualTo(2)
    }
}
