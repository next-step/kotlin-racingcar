package domain.step3.domain.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingCarTest {

    @Test
    fun `RacingCar getter 테스트`() {
        // given
        val racingCar = RacingCar { true }

        // when
        val movedRacingCar = racingCar.move()

        // then
        assertThat(movedRacingCar.distanceDriven).isEqualTo(1);
    }
}
