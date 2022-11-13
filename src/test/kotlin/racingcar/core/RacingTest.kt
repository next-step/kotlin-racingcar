package racingcar.core

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.ui.MessageCode

internal class RacingTest {
    @BeforeEach
    fun setUp() {
        Racing.setCarInit()
    }

    @ParameterizedTest
    @ValueSource(ints = [100, 3, 9])
    fun setCar(carNumber: Int) {
        Racing.setCars(carNumber)

        Racing.cars.count() shouldBe carNumber
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, Int.MIN_VALUE])
    fun `setCar throw Exception when carNumber is Incorrect`(carNumber: Int) {
        val exception = assertThrows<IllegalArgumentException> {
            Racing.setCars(carNumber)
        }
        assertThat(exception.message).isEqualTo(MessageCode.CarNumberException.message)
    }

    @ParameterizedTest
    @ValueSource(ints = [100, 3, 9])
    fun startRacing(carNumber: Int) {
        val tryNumber = 3
        Racing.setCars(carNumber)

        val moveResult = Racing.startRacing(tryNumber = tryNumber)

        moveResult.count() shouldBe carNumber
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, Int.MIN_VALUE])
    fun `startRacing throw Exception when tryNumber is Incorrect`(tryNumber: Int) {
        val exception = assertThrows<IllegalArgumentException> {
            Racing.startRacing(tryNumber = tryNumber)
        }

        assertThat(exception.message).isEqualTo(MessageCode.TryNumberException.message)
    }
}
