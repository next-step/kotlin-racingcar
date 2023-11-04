package study.racingcar.domain

import org.assertj.core.api.AssertionsForInterfaceTypes
import org.assertj.core.api.Java6Assertions.assertThat
import org.assertj.core.api.Java6Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RacingGameTest {

    private val alwaysMoveGenerator = object : RandomValueGenerator {
        override fun invoke(): Int = 5
    }

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
        val valueGenerator = object : RandomValueGenerator {
            override fun invoke(): Int = randomValue
        }
        val racingGame = RacingGame(listOf("hong", "lee", "kim"), rounds, valueGenerator)
        racingGame.run {}
        assertThat(racingGame.cars.list.all { it.position == expectedPosition }).isTrue
    }

    @Test
    fun `should throw exception when number of rounds is negative`() {
        assertThatThrownBy {
            RacingGame(listOf("hong", "lee", "kim"), -5)
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
        val racingGame = RacingGame(listOf("hong", "lee", "kim"), 5, alwaysMoveGenerator)
        val car = Car("test")
        val movedCar = racingGame.move(car, randomValue)
        assertThat(movedCar.position).isEqualTo(expectedPosition)
    }

    @Test
    fun `moveAll should move all cars based on the provided random values`() {
        val racingGame = RacingGame(listOf("hong", "lee"), 5, alwaysMoveGenerator)
        val initialCars = racingGame.cars.copy()
        val movedCars = racingGame.moveAll(initialCars, alwaysMoveGenerator)

        val expectedPositions = listOf(
            racingGame.move(initialCars.list[0], alwaysMoveGenerator()),
            racingGame.move(initialCars.list[1], alwaysMoveGenerator())
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
        val racingGame = RacingGame(cars, 5, alwaysMoveGenerator)

        val winners = racingGame.getWinners()
        AssertionsForInterfaceTypes.assertThat(
            winners.list.map {
                it.name
            }
        ).containsExactlyInAnyOrder("hong", "lee")
    }
}
