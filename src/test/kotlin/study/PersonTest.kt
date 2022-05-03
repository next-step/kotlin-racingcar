package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class PersonTest : StringSpec({
    "이름 붙인 인자" {
        val people = listOf(
            Person("손재빈", 34, "인트"),
            Person("손재빈", 34, nickname = "인트"),
            Person(name = "손재빈", nickname = "인트", age = 34)
        )

        people.forAll {
            it.name shouldBe "손재빈"
            it.age shouldBe 34
            it.nickname shouldBe "인트"
        }
    }

    "널 타입" {
        val person = Person("손재빈", 34, null)

        person.name shouldBe "손재빈"
        person.age shouldBe 34
        person.nickname.shouldBeNull()
    }

    "기본 인자" {
        val person = Person("손재빈", 34)

        person.name shouldBe "손재빈"
        person.age shouldBe 34
        person.nickname.shouldBeNull()
    }

    "데이터 클래스" {
        val person1 = Person("손재빈", 34, "인트")
        val person2 = Person("손재빈", 34, "인트")

        person1 shouldBe person2
    }
})
