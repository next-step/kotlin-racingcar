package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

// Found interface kotlin.time.TimeMark
class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val actual = Person(name = "양연수", nickname = "Hong", age = 20)
        actual.name shouldBe "양연수"
        actual.nickname shouldBe "Hong"
        actual.age shouldBe 20
    }
})
