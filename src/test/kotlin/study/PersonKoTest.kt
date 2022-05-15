package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val people = listOf(
            Person("염세란", 32, "세렌"), Person("염세란", 32, nickname = "세렌"), Person(name = "염세란", age = 32, nickname = "세렌")
        )
        people.forAll {
            it.name shouldBe "염세란"
            it.age shouldBe 32
            it.nickname shouldBe "세렌"
        }
    }

    "널 타입" {
        val person = Person("염세란", 32, nickname = null)
        person.name shouldBe "염세란"
        person.age shouldBe 32
        person.nickname shouldBe "null"
    }

    "기본 인자" {
        val person = Person("염세란", 32)
        person.name shouldBe "염세란"
        person.age shouldBe 32
        person.nickname shouldBe "염세란"
    }

    "데이터 클래스" {
        val person1 = Person("염세란", 32)
        val person2 = Person("염세란", 32)
        person1 shouldBe person2
    }
})
