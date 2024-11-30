package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.Cars

class CarsTest {
    @Test
    @DisplayName("랜덤값이 4보다 크면 이동거리 1을 추가하여 저장한다.")
    fun carCountTest() {
        val names = "red,blue"
        val cars = Cars(names.split(","), 1) { 4 }
        val testCarList = listOf(Car("red", 1), Car("blue", 1))
        val testCars = Cars(testCarList)
        assertThat(cars).isEqualTo(testCars)
    }

    @Test
    @DisplayName("제일 거리가 긴 Car 객체를 찾아 저장후 반환한다.")
    fun createWinningCarListTest() {
        val testCarList =
            listOf(
                Car("red", 2),
                Car("blue", 2),
                Car("kaki", 1),
            )
        val expected = listOf(Car("red", 2), Car("blue", 2))
        val cars = Cars(testCarList)
        val actual = cars.findWinner()
        assertThat(expected).isEqualTo(actual)
    }
}
