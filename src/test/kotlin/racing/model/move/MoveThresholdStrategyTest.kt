package racing.model.move

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racing.model.generator.ObedientGenerator

class MoveThresholdStrategyTest : StringSpec({

    "4 미만인 경우 정지한다" {
        MoveThresholdStrategy(ObedientGenerator(1)).movable() shouldBe false
        MoveThresholdStrategy(ObedientGenerator(2)).movable() shouldBe false
        MoveThresholdStrategy(ObedientGenerator(3)).movable() shouldBe false
    }

    "4 미만인 경우 정지한다_slim" {
        (1..3).forEach {
            MoveThresholdStrategy(ObedientGenerator(it)).movable() shouldBe false
        }
    }

    "4이상일 경우 전진한다" {
        MoveThresholdStrategy(ObedientGenerator(4)).movable() shouldBe true
        MoveThresholdStrategy(ObedientGenerator(5)).movable() shouldBe true
        MoveThresholdStrategy(ObedientGenerator(6)).movable() shouldBe true
        MoveThresholdStrategy(ObedientGenerator(7)).movable() shouldBe true
        MoveThresholdStrategy(ObedientGenerator(8)).movable() shouldBe true
        MoveThresholdStrategy(ObedientGenerator(9)).movable() shouldBe true
    }

    "4이상일 경우 전진한다_slim" {
        (4..9).forEach {
            MoveThresholdStrategy(ObedientGenerator(it)).movable() shouldBe true
        }
    }
})
