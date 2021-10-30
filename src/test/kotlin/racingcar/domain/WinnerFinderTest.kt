package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.dtos.GameResult
import racingcar.domain.dtos.RoundResult
import racingcar.domain.WinnerFinder

class WinnerFinderTest {
    @Test
    fun `게임 결과로부터 우승자를 찾아 리턴한다`() {
        val carOne = Car("test1", 0)
        val carTwo = Car("test2", 100)
        val carThree = Car("test3", 0)
        val roundResults = listOf(
            RoundResult(
                listOf(
                    carOne, carTwo, carThree
                )
            )
        )
        val gameResult = GameResult(roundResults)

        val winners = WinnerFinder().find(gameResult)

        assertThat(winners).isEqualTo(listOf(carTwo))
    }

    @Test
    fun `우승자가 복수인 경우, 모두 리턴한다`() {
        val carOne = Car("test1", 0)
        val carTwo = Car("test2", 100)
        val carThree = Car("test3", 100)
        val roundResults = listOf(
            RoundResult(
                listOf(
                    carOne, carTwo, carThree
                )
            )
        )
        val gameResult = GameResult(roundResults)

        val winners = WinnerFinder().find(gameResult)

        assertThat(winners).isEqualTo(listOf(carTwo, carThree))
    }
}
