package study

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class PersonTest : AnnotationSpec() {

    @Test
    fun `named args`() {
        val people = listOf(
            Person("신병주", 28, "요한"),
            Person("신병주", 28, nickname = "요한"),
            Person(name = "신병주", age = 28, nickname = "요한"),
        )

        people[0].name shouldBe "신병주"
        people[1].name shouldBe "신병주"
        people[2].name shouldBe "신병주"
    }

    @Test
    fun `null type`() {
        val person = Person("신병주", 28, null)
        person.name shouldBe "신병주"
        person.age shouldBe 28
        person.nickname.shouldBeNull()
    }

    @Test
    fun `default args`() {
        val person = Person("신병주", 28)
        person.name shouldBe "신병주"
        person.age shouldBe 28
        person.nickname.shouldBeNull()
    }

    @Test
    fun `data class`() {
        val person1 = Person("신병주", 28)
        val person2 = Person("신병주", 28)
        person1.shouldBeEqualToComparingFields(person2)
    }
}
