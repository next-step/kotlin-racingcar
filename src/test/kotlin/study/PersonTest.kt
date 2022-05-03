package study

import Person
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class PersonTest : AnnotationSpec() {

    @Test
    fun `named argument`() {
        listOf(
            Person("김해중", 39, "래리"), Person("김해중", 39, "래리"), Person("김해중", 39, "래리")
        ).forEach {
            it.name shouldBe "김해중"
        }
    }

    @Test
    fun `nullable nickname`() {
        val person = Person("김해중", 39, null)
        person.name shouldBe "김해중"
        person.age shouldBe 39
        person.nickname shouldBe null
    }

    @Test
    fun `default argument`() {
        val person = Person("김해중", 39)
        person.name shouldBe "김해중"
        person.age shouldBe 39
        person.nickname shouldBe "김해중"
    }

    @Test
    fun `data class`() {
        val person1 = Person("김해중", 39)
        val person2 = Person("김해중", 39)
        person1 shouldBe person2
    }
}
