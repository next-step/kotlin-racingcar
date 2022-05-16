package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val people = listOf(
            Person("엄기훈", 33, "치즈아부지"),
            Person("엄기훈", 33, nickname = "치즈아부지"),
            Person(name = "엄기훈", age = 33, nickname = "치즈아부지")
        )
        people.forAll {
            it.name shouldBe "엄기훈"
            it.age shouldBe 33
            it.nickname shouldBe "치즈아부지"
        }
    }
})
