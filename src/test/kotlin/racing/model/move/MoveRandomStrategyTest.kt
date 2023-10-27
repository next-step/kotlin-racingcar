package racing.model.move

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racing.model.generator.DocileGenerator

class MoveRandomStrategyTest : StringSpec({

    "4 미만인 경우 정지한다" {
        MoveRandomStrategy(DocileGenerator(1)).goNext() shouldBe false
        MoveRandomStrategy(DocileGenerator(2)).goNext() shouldBe false
        MoveRandomStrategy(DocileGenerator(3)).goNext() shouldBe false
    }

    "4이상일 경우 전진한다" {
        MoveRandomStrategy(DocileGenerator(4)).goNext() shouldBe true
        MoveRandomStrategy(DocileGenerator(5)).goNext() shouldBe true
        MoveRandomStrategy(DocileGenerator(6)).goNext() shouldBe true
        MoveRandomStrategy(DocileGenerator(7)).goNext() shouldBe true
        MoveRandomStrategy(DocileGenerator(8)).goNext() shouldBe true
        MoveRandomStrategy(DocileGenerator(9)).goNext() shouldBe true
    }
})
