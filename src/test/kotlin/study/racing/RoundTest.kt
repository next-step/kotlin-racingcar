package study.racing

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import study.racing.domain.entity.RacingCar
import study.racing.domain.entity.Round
import study.racing.domain.repository.RacingCarRepository

class RoundTest {

    @Test
    fun `이미 종료된 라운드를 시작하면 에러가 발생한다`() {
        val repo = RacingCarRepository(RandomPowerSource())
        val round = Round(listOf(RacingCar(repo)))
        round.race()
        val exception = assertThrows<IllegalStateException> {
            round.race()
        }
        assert(exception.message == "이 라운드는 이미 종료되었습니다.")
    }
}