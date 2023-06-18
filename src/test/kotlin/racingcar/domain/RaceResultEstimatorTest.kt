package racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
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
        val initalList: MutableList<Car> = mutableListOf()
        for (i in 1 until 3) {
            initalList.add(Car(movable = StaticMoveStrategy(), name = "Winner$i"))
        }
        for (i in 3 until 6) {
            initalList.add(Car(movable = StaticMovingStopStrategy(), name = "Loser$i"))
        }

        val cars = initalList.toList()

        round.execute(cars)

        // when
        val result = raceResultEstimator.estimate(cars)

        // then
        // Assertions.assertThat(result).hasSize(2)
        Assertions.assertThat(result.toString()).isEqualTo("[Winner1, Winner2]")
    }
}
