package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class PositionTest {
    @Test
    fun `Position의 기본 값은 1이다`() {
        Position().value shouldBe 1
    }

    @Test
    fun `1 미만의 값은 예외를 발생한다`() {
        shouldThrow<IllegalArgumentException> { Position(0) }
    }
}