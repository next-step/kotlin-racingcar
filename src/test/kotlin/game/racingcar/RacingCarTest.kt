package game.racingcar

import game.racingcar.move.AlwaysMoveStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingCarTest {
    @Test
    fun `자동차가 move 메서드를 호출하면 1만큼 앞으로 전진한다`() {
        // given
        val racingCar = RacingCar(AlwaysMoveStrategy())
        val preLocation = 0
        // when
        racingCar.move()
        // then
        assertThat(racingCar.location).isEqualTo(preLocation + 1)
    }
}
