package game.racingcar

import game.racingcar.move.AlwaysMoveStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingCarsTest {

    @Test
    fun `RacingCars가 AlwaysMoveStrategy로 생성되었을 때 모두 위치가 1씩 증가한다`() {
        // given
        val racingCars = RacingCars(3, AlwaysMoveStrategy())
        // when
        val snapshot = racingCars.moveAll()
        // then
        snapshot.forEach {
            assertThat(it).isEqualTo(1)
        }
    }
}
