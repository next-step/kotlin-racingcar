package racingcar.domain

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.exception.NoWinnerException
import racingcar.domain.move.StaticMoveStrategy
import racingcar.domain.move.StaticMovingStopStrategy

class RaceResultEstimatorTest {

    private lateinit var raceResultEstimator: RaceResultEstimator
    private lateinit var round: Round

    @BeforeEach
    fun setUp() {
        raceResultEstimator = RaceResultEstimator()
        round = Round()
    }

    @Test
    fun `경주 결과로 Winner1, Winner2를 출력`() {

        // given
        val cars = listOf(
            Car(movable = StaticMoveStrategy(), name = "Win1"),
            Car(movable = StaticMoveStrategy(), name = "Win2"),
            Car(movable = StaticMovingStopStrategy(), name = "Lose1"),
            Car(movable = StaticMovingStopStrategy(), name = "Lose2"),
            Car(movable = StaticMovingStopStrategy(), name = "Lose3"),
        )

        val carNames = setOf("Win1", "Win2")

        round.execute(cars)

        // when
        val actual = raceResultEstimator.estimate(cars).winnerNameSet

        // then
        assertTrue(actual == carNames)
    }

    @Test
    fun `경주 우승자가 없으면 NoWinnerException을 발생`() {
        val cars: List<Car> = listOf()

        assertThrows<NoWinnerException> {
            raceResultEstimator.estimate(cars)
        }
    }
}
