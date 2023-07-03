package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.Test

class RoundTest {

    @Test
    fun `라운드가 0 이하이면 예외가 발생한다`() {
        shouldThrow<IllegalArgumentException> { Round(0) }
    }
}
