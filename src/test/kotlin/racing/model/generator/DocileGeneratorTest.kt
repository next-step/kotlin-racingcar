package racing.model.generator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class DocileGeneratorTest : StringSpec({
    "랜덤값을 테스트할수 있도록 인터페이스화한다" {
        DocileGenerator(1).generate() shouldBe 1
        DocileGenerator(2).generate() shouldBe 2
        DocileGenerator(3).generate() shouldBe 3
        DocileGenerator(4).generate() shouldBe 4
        DocileGenerator(5).generate() shouldBe 5
        DocileGenerator(6).generate() shouldBe 6
        DocileGenerator(7).generate() shouldBe 7
        DocileGenerator(8).generate() shouldBe 8
        DocileGenerator(9).generate() shouldBe 9
    }
})
