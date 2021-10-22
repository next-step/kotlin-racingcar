package car.racing.usecase

import car.racing.domain.Car
import car.racing.helper.AboveStandardGenerator
import car.racing.helper.BelowStandardGenerator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindRaceWinnerTest {

    @Test
    fun `우승자가 1명일 때`() {
        val findRaceWinner = FindRaceWinner()
        val turnCount = 5
        val winner = Car("win", turnCount, NumberMovingStrategy(AboveStandardGenerator()))
        val loser1 = Car("l1", turnCount, NumberMovingStrategy(BelowStandardGenerator()))
        val loser2 = Car("l2", turnCount, NumberMovingStrategy(BelowStandardGenerator()))
        val cars = listOf(winner, loser1, loser2)

        repeat(turnCount) { turn ->
            cars.forEach { car ->
                car.move()
            }
        }

        val winners = findRaceWinner.findByCars(cars, turnCount)

        assertEquals(listOf(winner), winners)
    }

    @Test
    fun `우승자가 2명일 때`() {
        val findRaceWinner = FindRaceWinner()
        val turnCount = 5
        val winner1 = Car("win1", turnCount, NumberMovingStrategy(AboveStandardGenerator()))
        val winner2 = Car("win2", turnCount, NumberMovingStrategy(AboveStandardGenerator()))
        val loser = Car("lose", turnCount, NumberMovingStrategy(BelowStandardGenerator()))
        val cars = listOf(winner1, winner2, loser)

        repeat(turnCount) {
            cars.forEach { car ->
                car.move()
            }
        }

        val winners = findRaceWinner.findByCars(cars, turnCount)

        assertEquals(listOf(winner1, winner2), winners)
    }

    @Test
    fun `우승자가 3명일 때`() {
        val findRaceWinner = FindRaceWinner()
        val turnCount = 5
        val winner1 = Car("win1", turnCount, NumberMovingStrategy(AboveStandardGenerator()))
        val winner2 = Car("win2", turnCount, NumberMovingStrategy(AboveStandardGenerator()))
        val winner3 = Car("win3", turnCount, NumberMovingStrategy(AboveStandardGenerator()))
        val cars = listOf(winner1, winner2, winner3)

        repeat(turnCount) {
            cars.forEach { car ->
                car.move()
            }
        }

        val winners = findRaceWinner.findByCars(cars, turnCount)

        assertEquals(listOf(winner1, winner2, winner3), winners)
    }
}
