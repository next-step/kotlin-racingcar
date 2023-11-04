package study.racingcar

import org.assertj.core.api.AssertionsForInterfaceTypes
import org.assertj.core.api.Java6Assertions.assertThat
import org.assertj.core.api.Java6Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RaceTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "3, 3, 0",
            "3, 6, 0",
            "3, 9, 0",
            "4, 3, 3",
            "4, 6, 6",
            "4, 9, 9",
            "6, 100, 100"
        ]
    )
    fun `race runs for given rounds`(randomValue: Int, rounds: Int, expectedPosition: Int) {
        val race = Race(listOf("hong", "lee", "kim"), rounds) { randomValue }
        race.run {}
        assertThat(race.cars.list.all { it.position == expectedPosition }).isTrue
    }

    @Test
    fun `should throw exception when number of rounds is negative`() {
        assertThatThrownBy {
            Race(listOf("hong", "lee", "kim"), -5)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Number of rounds must be positive")
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "0, 0",
            "1, 0",
            "2, 0",
            "3, 0",
            "4, 1",
            "5, 1",
            "6, 1"
        ]
    )
    fun `car moves if random value is 4 or more`(randomValue: Int, expectedPosition: Int) {
        val race = Race(listOf("hong", "lee", "kim"), 5) { randomValue }
        val car = Car("test")
        val movedCar = race.move(car, randomValue)
        assertThat(movedCar.position).isEqualTo(expectedPosition)
    }

    @Test
    fun `moveAll should move all cars based on the provided random values`() {
        val alwaysMoveGenerator = { 5 }
        val race = Race(listOf("hong", "lee"), 5, alwaysMoveGenerator)
        val initialCars = race.cars.copy()
        val movedCars = race.moveAll(initialCars, alwaysMoveGenerator)

        val expectedPositions = listOf(
            race.move(initialCars.list[0], alwaysMoveGenerator()),
            race.move(initialCars.list[1], alwaysMoveGenerator())
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
        val alwaysMoveGenerator = { 5 }
        val cars = Cars(listOf(Car("hong", 3), Car("lee", 3), Car("kim", 2)))
        val race = Race(cars, 5, alwaysMoveGenerator)

        val winners = race.getWinners()
        AssertionsForInterfaceTypes.assertThat(
            winners.list.map {
                it.name
            }
        ).containsExactlyInAnyOrder("hong", "lee")
    }
}
