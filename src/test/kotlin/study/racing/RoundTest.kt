package study.racing

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import study.racing.domain.entity.RacingCar
import study.racing.domain.entity.Round
import study.racing.domain.repository.RacingCarRepositoryImpl
import study.racing.domain.repository.RoundRepositoryImpl

class RoundTest {

    @Test
    fun `라운드를 시작하면 이동 후의 자동차 위치가 기록이 된다`() {
        val repo = RacingCarRepositoryImpl(RandomPowerSource())
        val round = Round(RoundRepositoryImpl(), listOf(RacingCar("", repo)))
        round.race()

        assert(round.records != null)
    }

    @Test
    fun `이미 종료된 라운드를 시작하면 에러가 발생한다`() {
        val repo = RacingCarRepositoryImpl(RandomPowerSource())
        val round = Round(RoundRepositoryImpl(), listOf(RacingCar("", repo)))
        round.race()
        val exception = assertThrows<IllegalStateException> {
            round.race()
        }
        assert(exception.message == "이 라운드는 이미 종료되었습니다.")
    }
}