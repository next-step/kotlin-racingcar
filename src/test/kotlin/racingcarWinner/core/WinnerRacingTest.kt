package racingcarWinner.core

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class WinnerRacingTest {

    private var winner = Winner()

    @BeforeEach
    fun setUp() {
        winner = Winner()
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, Int.MIN_VALUE])
    fun `startRacing throw Exception when tryNumber is Incorrect`(tryNumber: Int) {
        val carNames = "pobi,crong,honux"
        val cars = CarList.setCars(carNames.split(","))

        val exception = assertThrows<IllegalArgumentException> {
            WinnerRacing.startRacing(cars = cars, winner = winner, tryNumber = tryNumber)
        }

        Assertions.assertThat(exception.message).isEqualTo(MessageCode.TryNumberException.message)
    }

    @ParameterizedTest
    @ValueSource(strings = [ "pobi", "alen"])
    fun `startRacing throw Exception when carNumber is one`(carNames: String) {
        val tryNumber = 3
        val cars = CarList.setCars(carNames.split(","))
        val exception = assertThrows<IllegalArgumentException> {
            WinnerRacing.startRacing(cars = cars, winner = winner, tryNumber = tryNumber)
        }

        Assertions.assertThat(exception.message).isEqualTo(MessageCode.CarNumberException.message)
    }
}
