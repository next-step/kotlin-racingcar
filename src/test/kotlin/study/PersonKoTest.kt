package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val person = Person(name = "최원준", age = 26, nickname = "Hori")

        person.name shouldBe "최원준"
        person.age shouldBe 26
        person.nickname shouldBe "Hori"
    }

    "널 타입" {
        val person = Person(name = "최원준", age = 26, null)

        person.nickname shouldBe null
    }

    "기본 인자" {
        val person = Person(name = "최원준", age = 26)

        person.nickname shouldBe "최원준"
    }

    "데이터 클래스" {
        val person1 = Person(name = "최원준", age = 26)
        val person2 = Person(name = "최원준", age = 26)

        person1 shouldBe person2
    }
})
