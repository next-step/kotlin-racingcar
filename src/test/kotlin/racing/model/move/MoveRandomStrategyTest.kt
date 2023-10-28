package racing.model.move

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racing.model.generator.ObedientGenerator

class MoveRandomStrategyTest : StringSpec({

    "4 미만인 경우 정지한다" {
        MoveRandomStrategy(ObedientGenerator(1)).goNext() shouldBe false
        MoveRandomStrategy(ObedientGenerator(2)).goNext() shouldBe false
        MoveRandomStrategy(ObedientGenerator(3)).goNext() shouldBe false
    }

    "4이상일 경우 전진한다" {
        MoveRandomStrategy(ObedientGenerator(4)).goNext() shouldBe true
        MoveRandomStrategy(ObedientGenerator(5)).goNext() shouldBe true
        MoveRandomStrategy(ObedientGenerator(6)).goNext() shouldBe true
        MoveRandomStrategy(ObedientGenerator(7)).goNext() shouldBe true
        MoveRandomStrategy(ObedientGenerator(8)).goNext() shouldBe true
        MoveRandomStrategy(ObedientGenerator(9)).goNext() shouldBe true
    }
})
