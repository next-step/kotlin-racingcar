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

        "위치는 compareTo 를 사용할 수 있다" {

            Position(1).compareTo(Position(2)) shouldBe -1
            Position(1).compareTo(Position(1)) shouldBe 0
            Position(2).compareTo(Position(1)) shouldBe 1
        }
    }
}
