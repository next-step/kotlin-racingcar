package study.racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarsTest {
    private val alwaysMoveGenerator = object : RandomValueGenerator {
        override fun invoke(): Int = 5
    }

    @Test
    fun `moveAll should move all cars based on the provided random values`() {
        val racingGame = RacingGame(listOf("hong", "lee"), 5, alwaysMoveGenerator)
        val initialCars = racingGame.cars
        val initialCarList = racingGame.cars.list
        val movedCars = initialCars.moveAll(alwaysMoveGenerator)

        val expectedPositions = listOf(
            initialCarList[0].move(alwaysMoveGenerator()),
            initialCarList[1].move(alwaysMoveGenerator())
        ).map { it.position }
        val actualPositions = movedCars.list.map { it.position }

        assertEquals(
            expectedPositions,
            actualPositions,
            "Cars should move based on the provided random values"
        )
    }
}
