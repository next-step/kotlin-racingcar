package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

//Found interface kotlin.time.TimeMark, but class was expected
class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val actual = Person(name = "윤성현", age = 20, nickname = "minhyukseul")
        actual.name shouldBe "윤성현"
        actual.nickname shouldBe "minhyukseul"
        actual.age shouldBe 20
    }
})