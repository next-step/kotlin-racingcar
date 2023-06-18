package racingCarTest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingCar.RacingField

class RacingFieldTest {
    @Test
    fun `자동차 수 테스트`() {
        val racingField = RacingField(3, 0)
        assertThat(racingField.getCarCount()).isEqualTo(3)
    }

    @Test
    fun `자동차 수 음수 테스트`() {
        val racingField = RacingField(-3, 0)
        assertThat(racingField.getCarCount()).isEqualTo(1)
    }

    @Test
    fun `경기 실행 수 설정 테스트`() {
        val racingField = RacingField(0, 5)
        assertThat(racingField.getGameCount()).isEqualTo(5)
    }

    @Test
    fun `경기 실행 수 음수 테스트`() {
        val racingField = RacingField(0, -5)
        assertThat(racingField.getGameCount()).isEqualTo(1)
    }

    @Test
    fun `레이싱 경기 게임 실행 테스트`() {
        val carCount = 5
        val gameCount = 100
        val racingField = RacingField(carCount, gameCount)

        repeat(gameCount) {
            racingField.gameStart()
            assertThat(racingField.getCarsDistance().stream().allMatch { it in 0..gameCount })
        }
    }
}
