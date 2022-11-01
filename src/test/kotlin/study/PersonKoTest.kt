package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val person = Person(name = "홍길동", age = 10, nickname = "도둑")
        person.name shouldBe "홍길동"
        person.age shouldBe 10
        person.nickname shouldBe "도둑"
    }

    "null 타입" {
        val person = Person("홍길동", 10, null)
        person.nickname.shouldBeNull()
    }

    "기본 인자" {
        val person = Person("홍길동", 10)
        person.nickname shouldBe person.name
    }

    "데이터 클래스" {
        val person = Person("홍길동", 10)
        val person2 = Person("홍길동", 10)
        person shouldBe person2
    }
})
