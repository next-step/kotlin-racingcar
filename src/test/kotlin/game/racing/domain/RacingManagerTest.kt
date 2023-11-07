package game.racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class RacingManagerTest {
    @ParameterizedTest
    @ValueSource(strings = ["WIN,TEST2,TEST3", "TEST1,TEST2,WIN,TEST4", "TEST1,WIN,TEST3,TEST4,TEST5"])
    fun `우승자를 반환한다`(carNames: String) {
        val cars = carNames.split(",").toTypedArray().map { Car(it) }
        val racingManager = RacingManager(cars)
        cars.forEach {
            if (it.name == "WIN") {
                it.moveOrStayBySpeed(Car.MIN_MOVE_THRESHOLD)
            }
        }

        assertThat(racingManager.determineWinner()).allMatch { it.position == Car.MIN_POSITION + 1 }.allMatch { it.name == "WIN" }
    }
}
