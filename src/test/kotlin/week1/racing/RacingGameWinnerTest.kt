package week1.racing

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import week1.racing.domain.RacingCar
import week1.racing.domain.RacingGameWinner

class RacingGameWinnerTest {
    @Test
    fun `{given} 움직인 거리가 3, 4, 5인 자동차 세 대 {when} getWinners() {then} 거리 5인 자동차가 우승`() {
        // given
        val racingGameWinner = RacingGameWinner()
        val winner = RacingCar("A", { true }, startingPosition = 5)

        val cars =
            listOf(
                RacingCar("A", { true }, startingPosition = 5),
                RacingCar("B", { true }, startingPosition = 4),
                RacingCar("C", { true }, startingPosition = 3),
            )

        // when
        val winnerList = racingGameWinner.getWinners(cars)
        // then
        assertTrue(winnerList.size == 1)
        assertTrue(winnerList.contains(winner))
    }

    @Test
    fun `{given} 움직인 거리 5, 5, 5 인 자동차 세 대 {when} getWinners() {then} 거리 5인 자동차 모두 우승`() {
        // given
        val racingGameWinner = RacingGameWinner()
        val cars =
            listOf(
                RacingCar("A", { true }, startingPosition = 5),
                RacingCar("B", { true }, startingPosition = 5),
                RacingCar("C", { true }, startingPosition = 5),
            )

        // when
        val winnerList = racingGameWinner.getWinners(cars)
        // then
        assertTrue(winnerList.size == 1)
        assertTrue(winnerList.containsAll(cars))
    }
}
