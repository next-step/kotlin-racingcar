package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class PersonKotlinTest : StringSpec({
    "이름 붙인 인자"() {
        val people = listOf(
            Person("김동우", 29, "몰리"),
            Person("김동우", 29, nickname = "몰리"), Person(name = "김동우", age = 29, nickname = "몰리")
        )

        people.forAll {
            it.name shouldBe "김동우"
            it.age shouldBe 29
            it.nickname shouldBe "몰리"
        }
    }

    "널 타입" {
        val person = Person("김동우", 29, null)
        person.name shouldBe "김동우"
        person.age shouldBe 29
        person.nickname shouldBe null
    }

    "기본 인자" {
        val person = Person("김동우", 29)
        person.name shouldBe "김동우"
        person.age shouldBe 29
        person.nickname shouldBe "김동우"
    }

    "데이터 클래스" {
        val person1 = Person("김동우", 29)
        val person2 = Person("김동우", 29)

        person1 shouldBe person2
    }
})
