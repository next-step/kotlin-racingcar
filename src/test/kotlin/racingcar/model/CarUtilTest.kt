package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarUtilTest {
    @Test
    fun `Car 생성`() {
        val cars = CarUtil.createCars(listOf("pobi", "crong"))
        assertThat(cars.size).isEqualTo(2)
    }

    @Test
    fun `우승자 구하기 - 가장 멀리간 차가 우승`() {
        // given
        val firstCar = Car("car1", 2)
        val secondCar = Car("car2", 4)
        val racingHistories = listOf<RacingHistory>(RacingHistory(0, listOf(firstCar, secondCar)))

        // when
        val winner = CarUtil.getWinner(racingHistories)

        // then
        assertThat(winner.size).isEqualTo(1)
        assertThat(winner.first().name).isEqualTo("car2")
        assertThat(winner.first().position).isEqualTo(4)
    }
}
