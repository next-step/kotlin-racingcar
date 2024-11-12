package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "Named Parameters" {
        val actual = Person(name = "Sara", age = 20, nickname = "Gary")
        actual.nickname shouldBe "Gary"
    }

    "Null Type" {
        val actual = Person(name = "Sara", age = 20, nickname = null)
        actual.nickname.shouldBeNull()
    }

    "Data class" {
        val person1 = Person(name = "Sara", age = 20, nickname = "Gary")
        val person2 = Person(name = "Sara", age = 20, nickname = "Gary")
        person1 shouldBe person2
    }

    "Default Parameter" {
        val person = Person(name = "Sara", age = 20)
        person.nickname shouldBe "Sara"
    }
})
