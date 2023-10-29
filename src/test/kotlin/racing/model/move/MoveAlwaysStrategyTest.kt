package racing.model.move

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MoveAlwaysStrategyTest : StringSpec({
    "모든 경우에 이동 해야 한다" {
        val strategy = MoveAlwaysStrategy()
        strategy.movable() shouldBe true
        strategy.movable() shouldBe true
        strategy.movable() shouldBe true
    }
})
