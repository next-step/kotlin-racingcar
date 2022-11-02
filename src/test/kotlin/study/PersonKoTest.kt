package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        // when
        val person = Person(name = "김기연", age = 28, nickName = "코린이")

        // then
        person.name shouldBe "김기연"
        person.age shouldBe 28
        person.nickName shouldBe "코린이"
    }

    "널 타입" {
        // when
        val person = Person("김기연", 28, null)

        // then
        person.nickName.shouldBeNull()
    }

    "기본 인자" {
        // when
        val person = Person("김기연", 28)

        // then
        person.name shouldBe person.nickName
    }

    "데이터 클래스" {
        // when
        val person = Person("김기연", 28)

        // then
        person shouldBe Person("김기연", 28)
    }
})
