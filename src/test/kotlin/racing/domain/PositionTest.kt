package racing.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PositionTest : StringSpec() {
    init {
        "위치는 0 이상만 가능하다" {
            shouldThrow<IllegalArgumentException> {
                Position(-1)
            }
        }

        "위치는 더해질 수 있다" {
            val position = Position()

            position.move() shouldBe Position(1)
        }

        "위치는 서로 비교해 더 큰 값을 반환할 수 있다" {
            Position(1).max(Position(2)) shouldBe Position(2)
        }
    }
}
