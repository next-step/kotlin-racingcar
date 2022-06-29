package racingCar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingCar.entity.Car
import racingCar.entity.CarImpl

internal class RacingCarGameTest {

    @Test
    fun `4대의 자동차를 만든다`() {
        // given
        val carNames = listOf<String>("A", "B", "C", "D")
        val expectedSize = 4

        // when
        val resultCars = RacingCarGame().generateCars(carNames)

        // then
        Assertions.assertThat(resultCars.size).isEqualTo(expectedSize)
    }

    @Test
    fun `generateRandomNumber는 0과 9 사이의 중 하나의 숫자를 임의로 생성한다`() {
        // when
        val rangeList = (0..9)
        val testNumber = RacingCarGame().generateRandomNumber()

        // then
        Assertions.assertThat(rangeList).contains(testNumber)
    }

    @Test
    fun `거리가 5 4 5 2 를 간 자동차가 있으면 가장 멀리간 거리는 5가 된다`(){
        // given
        val cars = listOf<Car>(CarImpl("A", 5), CarImpl("B", 4), CarImpl("C", 5), CarImpl("D", 2))
        val expectedMaxLength = 5

        // when
        val result = RacingCarGame().getMaxDistance(cars)

        // then
        Assertions.assertThat(expectedMaxLength).isEqualTo(result)
    }

    @Test
    fun `거리가 5 4 5 2 를 간 자동차가 있으면 가장 멀리간 거리는 4가 아니다`(){
        // given
        val cars = listOf<Car>(CarImpl("A", 5), CarImpl("B", 4), CarImpl("C", 5), CarImpl("D", 2))
        val expectedMaxLength = 4

        // when
        val result = RacingCarGame().getMaxDistance(cars)

        // then
        Assertions.assertThat(expectedMaxLength).isNotEqualTo(result)
    }

    @Test
    fun `거리가 5 4 2를 간 자동차가 있으면 우승자는 거리 5인 자동차이다`(){
        // given
        val cars = listOf<Car>(CarImpl("A", 5), CarImpl("B", 4), CarImpl("D", 2))
        val expectedCarName = "A"

        // when
        val result = RacingCarGame().getWinner(cars)

        // then
        Assertions.assertThat(expectedCarName).isNotEqualTo(result)
    }

    @Test
    fun `거리가 5 4 5 2를 간 자동차가 있으면 우승한 차가 두 대 이다`(){
        // given
        val cars = listOf<Car>(CarImpl("A", 5), CarImpl("B", 4), CarImpl("C", 5), CarImpl("D", 2))
        val expectedCarSize = 2

        // when
        val result = RacingCarGame().getWinner(cars)

        // then
        Assertions.assertThat(expectedCarSize).isNotEqualTo(result)
    }

    @Test
    fun `거리가 5 4 5 2를 간 자동차가 있으면 우승자는 거리 5인 자동차이다`(){
        // given
        val cars = listOf<Car>(CarImpl("A", 5), CarImpl("B", 4), CarImpl("C", 5), CarImpl("D", 2))
        val expectedWinnersName = listOf<String>("A", "C")

        // when
        val result = RacingCarGame().getWinner(cars)

        // then
        Assertions.assertThat(expectedWinnersName).isEqualTo(result)
    }
}
