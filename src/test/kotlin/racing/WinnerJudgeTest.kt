package racing

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racing.common.CarRaceProperty
import racing.race.WinnerJudge

class WinnerJudgeTest {

    @Test
    fun `레이스 경기 이후, 우승자 테스트`() {
        val roundSize = 1
        val carNames = listOf("A", "B", "C")
        val carRaceProperty = CarRaceProperty(roundSize, carNames)
        carRaceProperty.cars[0].moveForward()

        val winnerJudge = WinnerJudge(carRaceProperty)
        Assertions.assertThat(winnerJudge.getWinnerCarNames()).isEqualTo("A")
    }

    @Test
    fun `레이스 경기 이후, 우승자를 선정하기 위한 카운트 테스트`() {
        val roundSize = 5
        val carNames = listOf("A", "B", "C")
        val carRaceProperty = CarRaceProperty(roundSize, carNames)
        carRaceProperty.cars[0].moveForward()
        carRaceProperty.cars[0].moveForward()
        carRaceProperty.cars[0].moveForward()

        val winnerJudge = WinnerJudge(carRaceProperty)
        val getWinnerCountMethod = winnerJudge.javaClass.getDeclaredMethod("getWinnerCount")
        getWinnerCountMethod.isAccessible = true

        Assertions.assertThat(getWinnerCountMethod.invoke(winnerJudge)).isEqualTo(3)
    }
}
