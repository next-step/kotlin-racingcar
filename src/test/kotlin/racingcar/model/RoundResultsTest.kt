package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RoundResultsTest {

    @Test
    fun `차가 움직일 때 각 결과를 저장할 수 있다`() {
        // given
        val carNames = listOf(CarName("a"), CarName("b"))
        val cars = CarsFactory.createCars(TrueEngineCarCreator(), carNames)
        val roundResults = RoundResults()

        // when
        cars.move()
        roundResults.save(cars)
        val result = roundResults.getRoundResults()

        // then
        assertThat(result).hasSize(1)
        assertThat(result).containsExactly(
            RoundResults.RoundResult(1, listOf(RoundResults.CarMoveResult("a", 1), RoundResults.CarMoveResult("b", 1))),
        )
    }

    @Test
    fun `차가 움직일 때 각 결과는 라운드를 기준으로 정렬된다`() {
        // given
        val carNames = listOf(CarName("a"), CarName("b"))
        val cars = CarsFactory.createCars(TrueEngineCarCreator(), carNames)
        val roundResults = RoundResults()

        // when
        cars.move()
        roundResults.save(cars)
        cars.move()
        roundResults.save(cars)
        val result = roundResults.getRoundResults()

        // then
        assertThat(result).hasSize(2)
        assertThat(result).containsExactly(
            RoundResults.RoundResult(1, listOf(RoundResults.CarMoveResult("a", 1), RoundResults.CarMoveResult("b", 1))),
            RoundResults.RoundResult(2, listOf(RoundResults.CarMoveResult("a", 2), RoundResults.CarMoveResult("b", 2))),
        )
    }
}
