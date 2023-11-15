package game.racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class RacingManagerTest {
    @ParameterizedTest
    @MethodSource("provideCarList")
    fun `우승자를 반환한다`(cars: List<Car>) {
        // when
        val racingManager = RacingManager(cars)

        // then
        assertThat(racingManager.determineWinner()).allMatch { it.name == "WIN" }
    }

    @Test
    fun `자동차가 움직인다`() {
        val cars = listOf(Car("TEST1"), Car("TEST2"), Car("TEST3"))
        val racingManager = RacingManager(cars)
        racingManager.moveCars { Car.MIN_MOVE_THRESHOLD }

        assertThat(cars[0].position).isEqualTo(1)
        assertThat(cars[1].position).isEqualTo(1)
        assertThat(cars[2].position).isEqualTo(1)
    }

    companion object {
        private fun createCar(name: String, position: Int): Car {
            return Car(name).apply {
                repeat(position) {
                    this.moveOrStayBySpeed(Car.MIN_MOVE_THRESHOLD)
                }
            }
        }

        @JvmStatic
        fun provideCarList() = listOf(
            listOf(createCar("TEST1", 1), createCar("TEST2", 2), createCar("WIN", 3)),
            listOf(createCar("TEST1", 1), createCar("TEST2", 2), createCar("WIN", 3), createCar("TEST4", 2)),
            listOf(createCar("TEST1", 1), createCar("TEST2", 1), createCar("WIN", 5), createCar("TEST4", 3), createCar("TEST5", 3))
        )
    }
}
