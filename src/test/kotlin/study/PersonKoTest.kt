package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val person = Person(name = "전가빈", age = 30, nickname = "컴공돌이")
        person.name shouldBe "전가빈"
        person.age shouldBe 30
        person.nickname shouldBe "컴공돌이"
    }

    "null 타입" {
        val person = Person("전가빈", 30, null)
        person.nickname.shouldBeNull()
    }

    "기본 인자" {
        val person = Person("전가빈", 30)
        person.nickname shouldBe person.name
    }

    "데이터 클래스" {
        val person = Person("전가빈", 30)
        val person2 = Person("전가빈", 30)
        person shouldBe person2
    }
})
