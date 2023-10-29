package racing.model.move

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racing.model.generator.ObedientGenerator

class MoveRandomStrategyTest : StringSpec({

    "4 미만인 경우 정지한다" {
        MoveRandomStrategy(ObedientGenerator(1)).movable() shouldBe false
        MoveRandomStrategy(ObedientGenerator(2)).movable() shouldBe false
        MoveRandomStrategy(ObedientGenerator(3)).movable() shouldBe false
    }

    "4이상일 경우 전진한다" {
        MoveRandomStrategy(ObedientGenerator(4)).movable() shouldBe true
        MoveRandomStrategy(ObedientGenerator(5)).movable() shouldBe true
        MoveRandomStrategy(ObedientGenerator(6)).movable() shouldBe true
        MoveRandomStrategy(ObedientGenerator(7)).movable() shouldBe true
        MoveRandomStrategy(ObedientGenerator(8)).movable() shouldBe true
        MoveRandomStrategy(ObedientGenerator(9)).movable() shouldBe true
    }
})
