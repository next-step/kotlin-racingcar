package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class VictoryTest {

    @Test
    fun `우승자가 한명이 나오는지 테스트한다`() {

        val carList: List<Car> = listOf(Car("car1", 1), Car("car2", 2))
        val racingCar: RacingCar = RacingCar(carList)

        val victoryCarList: List<Car> = racingCar.victoryCar()

        assertThat(victoryCarList.size).isEqualTo(1)
    }

    @Test
    fun `우승자가 두명이 나오는지 테스트한다`() {

        val carList: List<Car> = listOf(Car("car1", 2), Car("car2", 2), Car("car4", 1), Car("car3", 0))
        val racingCar: RacingCar = RacingCar(carList)

        val victoryCarList: List<Car> = racingCar.victoryCar()

        assertThat(victoryCarList.size).isEqualTo(2)
    }

    @Test
    fun `우승자가 세명이 나오는지 테스트한다`() {

        val carList: List<Car> = listOf(Car("car1", 2), Car("car2", 2), Car("car3", 1), Car("car4", 2))
        val racingCar: RacingCar = RacingCar(carList)

        val victoryCarList: List<Car> = racingCar.victoryCar()

        assertThat(victoryCarList.size).isEqualTo(3)
    }

    @ParameterizedTest
    @ValueSource(strings = ["pobi,kazu"])
    fun `공동 우승자가 나오는지 테스트 한다`(string: String) {

        val racingCar: RacingCar = RacingCar(string.split(",").map { Car(it) })

        val victoryCarList: List<Car> = racingCar.victoryCar()
        assertThat(victoryCarList.size).isEqualTo(string.split(",").size)
    }
}
