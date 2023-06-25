package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.Test

class CarNamesTest {
    @Test
    fun `CarNames는 empty일 때 예외가 발생한다`() {
        shouldThrow<IllegalArgumentException> { CarNames(listOf()) }
    }
}