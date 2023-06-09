package step3.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarPositionTest : StringSpec({
    "[move 테스트] 호출하면 전진한다." {
        val initialPosition = CarPosition(0)
        val movedPosition = initialPosition.move()

        movedPosition.position shouldBe 1
    }
})
