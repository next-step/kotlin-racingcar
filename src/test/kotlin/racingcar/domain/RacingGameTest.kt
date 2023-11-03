package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.OnlyFalseMoveCondition
import racingcar.OnlyTrueMoveCondition

class RacingGameTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun `moveCondition이 항상 참이면 tryMoveCount 만큼 차가 이동한다`(count: Int) {
        val moveCondition = OnlyTrueMoveCondition()
        val cars = listOf(Car(moveCondition))
        val tryMoveCount: Int = count
        val gameRecorder = RacingGameRecorder()

        RacingGame().play(cars, tryMoveCount, gameRecorder)

        val carPosition = gameRecorder.gameResultRecord.finalRaceResult?.carPositions?.first()?.position

        assertThat(carPosition).isEqualTo(count)
    }

    @Test
    fun `이동 횟수가 0인 경우 라운드 기록이 남지 않는다`() {
        val moveCondition = OnlyTrueMoveCondition()
        val cars = listOf(Car(moveCondition))
        val tryMoveCount = 0
        val gameRecorder = RacingGameRecorder()

        RacingGame().play(cars, tryMoveCount, gameRecorder)

        assertThat(gameRecorder.gameResultRecord.raceResults.size).isEqualTo(0)
    }

    @Test
    fun `moveCondition에 따라 각각 차의 이동 거리가 다를 수 있다`() {
        val cars = listOf(
            Car(OnlyTrueMoveCondition()),
            Car(OnlyFalseMoveCondition()),
        )
        val tryMoveCount = 1
        val gameRecorder = RacingGameRecorder()

        RacingGame().play(cars, tryMoveCount, gameRecorder)

        val carPositions = gameRecorder.gameResultRecord.finalRaceResult?.carPositions
        val firstCarPosition = carPositions?.get(0)?.position
        val secondCarPosition = carPositions?.get(1)?.position

        assertThat(firstCarPosition).isNotEqualTo(secondCarPosition)
    }

    @Test
    fun `가장 많이 움직인 차가 우승한다`() {
        val cars = listOf(
            Car(OnlyTrueMoveCondition(), "winner"),
            Car(OnlyFalseMoveCondition(), "a"),
        )
        val tryMoveCount = 1
        val gameRecorder = RacingGameRecorder()

        RacingGame().play(cars, tryMoveCount, gameRecorder)

        val winnersName = gameRecorder.gameResultRecord.winners.names

        assertThat(winnersName).isEqualTo(listOf("winner"))
    }
}
