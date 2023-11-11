package racing.ui

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.Test
import racing.domain.Car

class InputViewTest {
    @Test
    fun `자동차의 이름은 5자를 초과하면 예외 발생`() {
        shouldThrow<IllegalArgumentException> {
            Car("Jiwon Kwon")
        }
    }
}
