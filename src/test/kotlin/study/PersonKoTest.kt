package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val person = Person(name = "shin", age = 20, nickname = "shinaaaa")
        person.name shouldBe "shin"
        person.age shouldBe "20"
        person.nickname shouldBe "shinaaaa"
    }

    "널 타입" {
        val person = Person(name = "shin", age = 20, nickname = null)
        person.nickname.shouldBeNull()
    }

    "기본 인자" {
        val person = Person(name = "shin", age = 20)
        person.name shouldBe person.nickname
    }

    "데이터 클래스" {
        val person1 = Person(name = "shin", age = 20)
        val person2 = Person(name = "shin", age = 20)
        person1.name shouldBe person2.nickname
    }

})