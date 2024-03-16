package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({

    "이름 붙인 인자" {
        val person = listOf(
            Person("김병화", 29, "마크"),
            Person("김병화", 29, nickname = "마크"),
            Person(
                name = "김병화",
                nickname = "마크",
                age = 29
            )
        )

        person.forEach {
            it.name shouldBe "김병화"
        }
    }

    "널 타입" {
        val person = Person("김병화", 29, null)
        person.name shouldBe "김병화"
        person.age shouldBe 29
        person.nickname shouldBe null
    }

    "기본 인자" {
        val person = Person("김병화", 29)
        person.name shouldBe "김병화"
        person.age shouldBe 29
        person.nickname shouldBe "김병화"
    }

    "데이터 클래스" {
        val person1 = Person("김병화", 29)
        val person2 = Person("김병화", 29)
        person1 shouldBe person2
    }
})
