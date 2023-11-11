package game.racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class RacingManagerTest {
    @ParameterizedTest
    @ValueSource(strings = ["WIN,TEST2,TEST3", "TEST1,TEST2,WIN,TEST4", "TEST1,WIN,TEST3,TEST4,TEST5"])
    fun `우승자를 반환한다`(carNames: String) {
        // given
        val cars = carNames.split(",").toTypedArray().map { Car(it) }

        // when
        val racingManager = RacingManager(cars)
        cars.filter { it.name != "WIN" }.forEach {
            it.moveOrStayBySpeed(Car.MIN_MOVE_THRESHOLD - 1)
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
}
