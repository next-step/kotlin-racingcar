package study.racingcar

import org.assertj.core.api.AssertionsForInterfaceTypes
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `moveAll should move all cars based on the provided random values`() {
        val initialCars = listOf(
            Car("hong"),
            Car("lee")
        )

        val cars = Cars(initialCars)
        val randomValueGenerator = { 5 }

        val movedCars = cars.moveAll(randomValueGenerator)

        val expectedPositions = listOf(
            initialCars[0].move(randomValueGenerator()),
            initialCars[1].move(randomValueGenerator())
        ).map { it.position }
        val actualPositions = movedCars.list.map { it.position }

        assertEquals(
            expectedPositions,
            actualPositions,
            "Cars should move based on the provided random values"
        )
    }

    @Test
    fun `get winners after race`() {
        val cars = Cars(listOf(Car("hong", 3), Car("lee", 3), Car("kim", 2)))
        val winners = cars.getWinners()
        AssertionsForInterfaceTypes.assertThat(
            winners.list.map {
                it.name
            }
        ).containsExactlyInAnyOrder("hong", "lee")
    }
}
