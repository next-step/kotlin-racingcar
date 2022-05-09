package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val people = listOf(
            Person("조성륜", 23, "빠삐코"),
            Person("조성륜", 23, nickname = "빠삐코"), Person(name = "조성륜", age = 23, nickname = "빠삐코")
        )

        people.forAll {
            it.name shouldBe "조성륜"
            it.age shouldBe 23
            it.nickname shouldBe "빠삐코"
        }
    }

    "널 타입" {
        val person = Person("조성륜", 23, null)
        person.name shouldBe "조성륜"
        person.age shouldBe 23
        person.nickname shouldBe null
    }

    "기본 인자" {
        val person = Person("조성륜", 23)
        person.name shouldBe "조성륜"
        person.age shouldBe 23
        person.nickname shouldBe "조성륜"
    }

    "데이터 클래스" {
        val person1 = Person("조성륜", 23)
        val person2 = Person("조성륜", 23)

        person1 shouldBe person2
    }
})
