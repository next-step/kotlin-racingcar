package study.racingcar.domain

import org.assertj.core.api.AssertionsForInterfaceTypes
import org.assertj.core.api.Java6Assertions.assertThat
import org.assertj.core.api.Java6Assertions.assertThatThrownBy
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
        racingGame.raceStart {}
        assertThat(racingGame.cars.list.all { it.position == expectedPosition }).isTrue
    }

    @Test
    fun `should throw exception when number of rounds is negative`() {
        assertThatThrownBy {
            RacingGame(listOf("hong", "lee", "kim"), -5)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Number of rounds must be positive")
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
