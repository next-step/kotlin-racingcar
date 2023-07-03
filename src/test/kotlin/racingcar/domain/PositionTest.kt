package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class PositionTest {

    @Test
    fun `기본 포지션은 0이다`() {
        val position = Position()

        position.value shouldBe 0
    }

    @Test
    fun `숫자를 받아 포지션을 생성한다`() {
        val position = Position(0)

        position.value shouldBe 0
    }

    @Test
    fun `포지션은 0 미만이면 예외가 발생한다`() {
        shouldThrow<IllegalArgumentException> { Position(-1) }
    }

    @Test
    fun `포지션의 다음 포지션을 반환한다`() {
        val position = Position(0)

        val nextPosition = position.next

        nextPosition.value shouldBe 1
    }
}
