package racing.model.generator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class ObedientGeneratorTest : StringSpec({
    "랜덤값을 테스트할수 있도록 인터페이스화한다" {
        ObedientGenerator(1).generate() shouldBe 1
        ObedientGenerator(2).generate() shouldBe 2
        ObedientGenerator(3).generate() shouldBe 3
        ObedientGenerator(4).generate() shouldBe 4
        ObedientGenerator(5).generate() shouldBe 5
        ObedientGenerator(6).generate() shouldBe 6
        ObedientGenerator(7).generate() shouldBe 7
        ObedientGenerator(8).generate() shouldBe 8
        ObedientGenerator(9).generate() shouldBe 9
    }

    "랜덤값을 테스트할수 있도록 인터페이스화한다_slim" {
        (1..9).forEach {
            ObedientGenerator(it).generate() shouldBe it
        }
    }

    "문제 요구사항의 지정범위를 초과하면 IllegalArgumentException throw" {
        shouldThrow<IllegalArgumentException> {
            ObedientGenerator(0).generate()
        }.shouldHaveMessage(ObedientGenerator(0).assertMessage)

        shouldThrow<IllegalArgumentException> {
            ObedientGenerator(10).generate()
        } shouldHaveMessage(ObedientGenerator(10).assertMessage)
    }
})
