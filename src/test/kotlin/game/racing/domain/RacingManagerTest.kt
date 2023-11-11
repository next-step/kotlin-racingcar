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
        cars.filter { it.name == "WIN" }.forEach {
            it.moveOrStayBySpeed(Car.MIN_MOVE_THRESHOLD)
        }

        // then
        assertThat(racingManager.determineWinner()).allMatch { it.position == Car.MIN_POSITION + 1 }.allMatch { it.name == "WIN" }
    }

    @Test
    fun `자동차가 움직인다`() {
        val cars = arrayOf(Car("TEST1"), Car("TEST2"), Car("TEST3"))
        val racingManager = RacingManager(cars.toList())
        racingManager.moveCars { Car.MIN_MOVE_THRESHOLD }

        assertThat(cars).allMatch { it.position == Car.MIN_POSITION + 1 }
    }

    companion object {
        @JvmStatic
        fun provideCarList() = listOf(
            listOf(Car("TEST1"), Car("TEST2"), Car("WIN")),
            listOf(Car("TEST1"), Car("TEST2"), Car("WIN"), Car("TEST4")),
            listOf(Car("TEST1"), Car("TEST2"), Car("WIN"), Car("TEST4"), Car("TEST5"))
        )
    }
}
