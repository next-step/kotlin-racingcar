package study

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.Test

class PreconditionsCheck {

    @Test
    fun testRequire() {
        shouldThrow<IllegalArgumentException> {
            require(false)
        }
    }
}