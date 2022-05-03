package study

import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class PersonTest : AnnotationSpec() {

    @Test
    fun `named arguments`() {
        val name = "시경덕"
        val age = 30
        val nickname = "KD"

        val people = listOf(
            Person(name, age, nickname),
            Person(name, age, nickname = nickname),
            Person(nickname = nickname, name = name, age = age),
        )

        people.forAll {
            it.name shouldBe name
            it.age shouldBe age
            it.nickname shouldBe nickname
        }
    }

    @Test
    fun `nullable types`() {
        val name = "시경덕"

        val person = Person(name, null, null)

        assertSoftly(person) {
            it.name shouldBe name
            age shouldBe null
            nickname shouldBe null
        }
    }

    @Test
    fun `default arguments`() {
        val name = "시경덕"

        var person = Person(name)

        assertSoftly(person) {
            it.name shouldBe name
            age shouldBe null
            nickname shouldBe name
        }
    }

    @Test
    fun `data classes`() {
        val name = "시경덕"
        val age = 30
        val nickname = "KD"

        val person1 = Person(name, age, nickname)
        val person2 = Person(name, age, nickname)

        person1 shouldBe person2
    }
}
