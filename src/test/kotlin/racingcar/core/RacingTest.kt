package racingcar.core

import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.ui.MessageCode

internal class RacingTest {

    @ParameterizedTest
    @ValueSource(ints = [100, 3, 9])
    fun startRacing(carNumber: Int) {
        val tryNumber = 3

        val moveResult = Racing(carNumber).startRacing(tryNumber = tryNumber)

        moveResult.count() shouldBe carNumber
        moveResult.forEach { carMoveStep ->
            carMoveStep shouldBeLessThanOrEqual tryNumber
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, Int.MIN_VALUE])
    fun `startRacing throw Exception when tryNumber is Incorrect`(tryNumber: Int) {
        val carNumber = 3
        val exception = assertThrows<IllegalArgumentException> {
            Racing(carNumber).startRacing(tryNumber = tryNumber)
        }

        assertThat(exception.message).isEqualTo(MessageCode.TryNumberException.message)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, Int.MIN_VALUE])
    fun `startRacing throw Exception when carNumber is Incorrect`(carNumber: Int) {
        val tryNumber = 3
        val exception = assertThrows<IllegalArgumentException> {
            Racing(carNumber).startRacing(tryNumber = tryNumber)
        }

        assertThat(exception.message).isEqualTo(MessageCode.CarNumberException.message)
    }
}
