package racing.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import racing.domain.movement.GoForwardMoveStrategy
import racing.domain.movement.StopMoveStrategy

internal class RacingCarTest {

    @DisplayName("4 이상의 숫자가 나온 경우 전진")
    @Test
    internal fun move_goForward() {
        val racingCar = createRacingCar("pobi")
        val expected = createRacingCar("pobi", 1)

        val actual = racingCar.move(GoForwardMoveStrategy())

        assertAll(
            { assertThat(actual.racingCarName.name).isEqualTo(expected.racingCarName.name) },
            { assertThat(actual.position).isEqualTo(expected.position) }
        )
    }

    @DisplayName("3 이하의 숫자가 나온 경우 정지")
    @Test
    internal fun move_stop() {
        val racingCar = createRacingCar("pobi")
        val expected = createRacingCar("pobi")

        val actual = racingCar.move(StopMoveStrategy())

        assertAll(
            { assertThat(actual.racingCarName.name).isEqualTo(expected.racingCarName.name) },
            { assertThat(actual.position).isEqualTo(expected.position) }
        )
    }
}
