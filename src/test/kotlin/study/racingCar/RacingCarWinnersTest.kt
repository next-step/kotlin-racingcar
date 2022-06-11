package study.racingCar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import study.racingCar.domain.Game
import study.racingCar.domain.Winners

class RacingCarWinnersTest {
    @Test
    fun `우승자는 한명이상일 수 있다`() {
        val carNames = listOf("test1", "test2", "test3")
        val tryNum = 5
        val mileageRecords = Game().startGame(carNames, tryNum)
        val winners = Winners().judgeWinners(mileageRecords)
        Assertions.assertThat(winners.size).isGreaterThanOrEqualTo(1)
    }
}
