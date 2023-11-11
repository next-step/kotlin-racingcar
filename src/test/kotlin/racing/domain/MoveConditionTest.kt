package racing.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class MoveConditionTest : FunSpec({

    test("movable") {
        // Given
        val movable = MoveCondition.movable { true }

        // Then
        movable shouldBe true
    }
})
