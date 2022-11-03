package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val person = Person(name = "황재우", age = 39, nickname = "dreamboy1339")
        person.name shouldBe "황재우"
        person.age shouldBe 39
        person.nickname shouldBe "dreamboy1339"
    }

    "널 타입" {
        val person = Person(name = "황재우", age = 39, nickname = null)
        person.nickname.shouldBeNull()
    }

    "기본 인자" {
        val person = Person("황재우", age = 39)
        person.nickname shouldBe "황재우"
    }

    "데이터 클래스" {
        val person = Person("황재우", 39)
        val person2 = Person("황재우", 39)
        person shouldBe person2
    }
})