package study.racing

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import racing.domain.RacingCar
import racing.domain.Round
import racing.dto.RacingCarInfo

class RoundTest : StringSpec({
    "3대의 차가 1라운드 경기를 실행한 결과를 반환한다" {
        val cars: List<RacingCar> = listOf(
            mockk {
                every { moveForward() } just Runs
                every { mapToRacingCarInfo() } returns RacingCarInfo(2)
            },
            mockk {
                every { moveForward() } just Runs
                every { mapToRacingCarInfo() } returns RacingCarInfo(2)
            },
            mockk {
                every { moveForward() } just Runs
                every { mapToRacingCarInfo() } returns RacingCarInfo(2)
            }
        )

        val round = Round(1, cars)

        val roundInfo = round.race()

        roundInfo.round shouldBe 1
        roundInfo.carInfos.size shouldBe 3
        roundInfo.carInfos.forEach {
            it.position shouldBe 2
        }
    }
})
