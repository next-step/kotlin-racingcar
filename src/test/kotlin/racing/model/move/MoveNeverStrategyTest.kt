package racing.model.move

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class MoveNeverStrategyTest : StringSpec({
    "모든 경우에 이동 하지 않아야 한다" {
        val strategy = MoveNeverStrategy()
        strategy.goNext() shouldBe false
        strategy.goNext() shouldBe false
        strategy.goNext() shouldBe false
    }
})
