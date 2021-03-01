package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingCarsTest {

    @Test
    fun `자동차 이동 성공 하면 위치가 증가 한다`() {
        // given
        val racingCars = createRacingCars(listOf(Car(), Car()))

        // when
        racingCars.nextRound()

        // then
        assertThat(racingCars.cars.map(Car::position)).isEqualTo(listOf(1, 1))
    }

    @Test
    fun `우승자를 조회 할수 있다`() {
        // given
        val winner = Car(position = 3)
        val racingCars = createRacingCars(listOf(winner, Car(position = 0)))

        // when, then
        assertThat(racingCars.winners).containsAll(listOf(winner))
    }

    private fun createRacingCars(cars: List<Car>): RacingCars {
        val movable = object : Movable { override fun isMovable(): Boolean = true }
        return RacingCars(cars, movable)
    }
}
