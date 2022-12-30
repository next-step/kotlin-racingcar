package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.entity.Car

class RacingTest {
    private val racing = Racing()

    @DisplayName(value = "우승자를 찾는다")
    @Test
    fun findWiningCar() {
        val car1 = Car("car1", "---")
        val car2 = Car("car2", "--")
        val winingCar = racing.findWinner(listOf(car1, car2))
        assertThat(winingCar.map { it.name }).isEqualTo(listOf(car1.name))
    }

    @DisplayName(value = "들어온 이름들로 cars를 만든다")
    @Test
    fun makeCars() {
        val carsName = listOf("name1", "name2", "name3", "name4", "name5")
        val cars = racing.makeCars(carsName)
        assertThat(cars.map { it.name }).isEqualTo(carsName)
    }
}
