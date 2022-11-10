package racingcar.core

import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.ui.MessageCode

internal class CarTest {

    @ParameterizedTest
    @ValueSource(ints = [100, 3, 9])
    fun move(tryNumber: Int) {
        val car = Car(tryNumber)

        val result = car.move()
        val resultCount = result.split(" ").count()

        resultCount shouldBeLessThanOrEqual tryNumber
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, Int.MIN_VALUE])
    fun `move throw Exception when tryNumber is Incorrect`(tryNumber: Int) {
        val car = Car(tryNumber)

        val exception = assertThrows<IllegalArgumentException> {
            car.move()
        }

        assertThat(exception.message).isEqualTo(MessageCode.TryNumberException.message)
    }
}
