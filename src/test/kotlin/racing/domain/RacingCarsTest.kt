package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingCarsTest {

    @Test
    fun `자동차 이동 성공 하면 위치가 증가 한다`() {
        // given
        val racingCars = createRacingCars(listOf(Car(), Car()))

        // when
        racingCars.nextRound(movable)

        // then
        assertThat(racingCars.cars.map(Car::position)).isEqualTo(listOf(1, 1))
    }

    @Test
    fun `우승자는 한 명 이상일 수 있다`() {
        // given
        val winner1 = Car("우승자1", position = 3)
        val winner2 = Car("우승자2", position = 3)
        val racingCars = createRacingCars(listOf(winner1, winner2, Car(position = 0)))

        // when, then
        assertThat(racingCars.winners).containsExactlyInAnyOrderElementsOf(listOf(winner1, winner2))
    }

    private fun createRacingCars(cars: List<Car>): RacingCars {

        return RacingCars(cars)
    }

    companion object {
        private val movable = object : Movable { override fun isMovable(): Boolean = true }
    }
}
