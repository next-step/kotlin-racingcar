package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import racingcar.car.Car
import racingcar.engine.CarEngine
import racingcar.manager.RacingManager
import java.util.stream.Stream

class RacingManagerTest {

    private lateinit var racingManager: RacingManager

    @ParameterizedTest(name = "Test {index}: value == {0} result == {1}")
    @MethodSource("racePositionTest")
    fun `race() 후 전부 움직였을 경우 position을 테스트`(value: List<String>, expected: List<String>) {
        // given
        val engine = object : CarEngine { override fun execute(): Boolean = true }
        racingManager = RacingManagerFactory().createRacingManager(value, engine)

        // when
        racingManager.race(attempts = 1)

        // then
        assertThat(racingManager.getPositions()).isEqualTo(listOf(1, 1, 1))
    }

    @Test
    fun `race() 후 findWinners() 테스트`() {
        // given
        val goEngine = object : CarEngine { override fun execute(): Boolean = true }
        val stopEngine = object : CarEngine { override fun execute(): Boolean = false }
        val cars = listOf(Car(carEngine = goEngine), Car(carEngine = stopEngine), Car(carEngine = goEngine))
        racingManager = RacingManager(cars)

        // when
        racingManager.race(attempts = 1)

        // then
        assertThat(racingManager.findWinners()).isEqualTo(listOf(Car(position = 1, carEngine = goEngine), Car(position = 1, carEngine = goEngine)))
    }

    companion object {
        @JvmStatic
        fun racePositionTest(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf("pobi", "crong", "honux"), listOf(1, 1, 1)),
            )
        }
    }
}
