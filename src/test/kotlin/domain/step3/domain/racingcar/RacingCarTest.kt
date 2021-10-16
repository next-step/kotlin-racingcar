package domain.step3.domain.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingCarTest {

    @Test
    fun `RacingCar 조건 만족시 이동 테스트`() {
        val racingCar = RacingCar { true }
        val movedRacingCar = racingCar.move()

        assertThat(movedRacingCar.distance).isEqualTo(1);
    }
}
