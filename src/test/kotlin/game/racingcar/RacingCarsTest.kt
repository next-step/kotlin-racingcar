package game.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingCarsTest {

    @Test
    fun `RacingCars 의 초기 위치 스냅샷은 모두 0이다`() {
        // given
        val racingCars = RacingCars(3)
        // when
        val snapshot = racingCars.locationSnapshot()
        // then
        snapshot.forEach {
            assertThat(it).isEqualTo(0)
        }
    }
}
