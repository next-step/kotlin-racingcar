package racing.domain.race

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racing.domain.FixtureBuilder.Companion.RandomNumberFixture
import racing.domain.common.CarRaceProperty

class WinnerJudgeTest {
    @Test
    fun `레이스 경기 이후, 우승자 테스트`() {
        val roundSize = 1
        val carNames = listOf("A", "B", "C")
        val carRaceProperty = CarRaceProperty(roundSize, carNames)
        val carRace = CarRace(carRaceProperty)
        val randomNumberFixture = RandomNumberFixture(6)
        carRace.start(randomNumberFixture)

        val winnerJudge = WinnerJudge(carRaceProperty)
        Assertions.assertThat(winnerJudge.getWinnerCarNames()).isEqualTo("A,B,C")
    }

    @Test
    fun `레이스 경기 이후, 우승자를 선정하기 위한 카운트 테스트`() {
        val roundSize = 5
        val carNames = listOf("A", "B", "C")
        val carRaceProperty = CarRaceProperty(roundSize, carNames)
        val carRace = CarRace(carRaceProperty)
        val randomNumberFixture = RandomNumberFixture(6)
        carRace.start(randomNumberFixture)

        val winnerJudge = WinnerJudge(carRaceProperty)
        val getWinnerCountMethod = winnerJudge.javaClass.getDeclaredMethod("getWinnerCount")
        getWinnerCountMethod.isAccessible = true

        Assertions.assertThat(getWinnerCountMethod.invoke(winnerJudge)).isEqualTo(5)
    }
}
