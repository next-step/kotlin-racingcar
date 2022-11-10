package racingcar.core

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.ui.MessageCode

internal class RacingTest {
    private val racing = Racing()

    @ParameterizedTest
    @ValueSource(ints = [100, 3, 9])
    fun startRacing(carNumber: Int) {
        val tryNumber = 5

        val result = racing.startRacing(carNumber = carNumber, tryNumber = tryNumber)

        result.count() shouldBe carNumber
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, Int.MIN_VALUE])
    fun `startRacing throw Exception when carNumber is Incorrect`(carNumber: Int) {
        val tryNumber = 5

        val exception = org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            racing.startRacing(carNumber = carNumber, tryNumber = tryNumber)
        }

        Assertions.assertThat(exception.message).isEqualTo(MessageCode.CarNumberException.message)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, Int.MIN_VALUE])
    fun `startRacing throw Exception when tryNumber is Incorrect`(tryNumber: Int) {
        val carNumber = 3

        val exception = org.junit.jupiter.api.assertThrows<IllegalArgumentException> {
            racing.startRacing(carNumber = carNumber, tryNumber = tryNumber)
        }

        Assertions.assertThat(exception.message).isEqualTo(MessageCode.TryNumberException.message)
    }
}
