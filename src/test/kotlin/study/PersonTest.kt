package study

import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.shouldForAll
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class PersonTest : FunSpec({

    test("이름 붙인 인자") {
        val people = listOf(
            Person("박민영", 29, "찰리"),
            Person("박민영", 29, nickname = "찰리"),
            Person(name = "박민영", nickname = "찰리", age = 29)
        )

        people.shouldForAll {
            it.name shouldBe "박민영"
            it.nickname shouldBe "찰리"
        }
    }

    test("널 타입") {
        val person = Person("박민영", null, null)

        person.name shouldBe "박민영"
        person.age.shouldBeNull()
        person.nickname.shouldBeNull()
    }

    test("기본 인자") {
        val person = Person("박민영", 29)

        person.name shouldBe "박민영"
        person.age shouldBe 29
        person.nickname shouldBe "찰리"
    }

    test("데이터 클래스") {
        val person1 = Person("박민영", 29, "찰리")
        val person2 = Person("박민영", 29, "찰리")

        person1.equals(person2).shouldBeTrue()
    }
})
