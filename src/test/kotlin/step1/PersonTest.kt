package step1

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class PersonTest {

    @Test
    fun constructor() {
        val person = Person(
            name = "손민성",
            age = 30,
            nickname = "손너잘"
        )

        person.name shouldBe ("손민성")

        person.nickname = "너잘손"
        person.nickname shouldBe ("너잘손")
    }

    @Test
    fun `named arguments`() {
        val people = listOf(
            Person("손민성", 30, "손너잘"),
            Person("손민성", 30, nickname = "손너잘"),
            Person(name = "손민성", age = 30, nickname = "손너잘")
        )

        assertThat(people).allSatisfy {
            it.name shouldBe "손민성"
            it.age shouldBe 30
            it.nickname shouldBe "손너잘"
        }
    }

    @Test
    fun `default arguments`() {
        val person = Person("손민성")

        assertAll(
            { person.name shouldBe "손민성" },
            { person.age shouldBe null },
            { person.nickname shouldBe null }
        )
    }

    @Test
    fun `data classes`() {
        val person1 = Person("손민성", 30, "손너잘")
        val person2 = Person("손민성", 30, "손너잘")
        assertThat(person1).isEqualTo(person2)
    }
}
