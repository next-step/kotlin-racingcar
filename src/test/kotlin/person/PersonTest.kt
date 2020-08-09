package person

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class PersonTest {

    @Test
    fun `Check person value`() {
        val person = Person("hyunsung", 30, "nanamare")
        Assertions.assertEquals("hyunsung", person.name)
        Assertions.assertEquals(30, person.age)
        Assertions.assertEquals("nanamare", person.nickname)
    }

    @Test
    fun `Compare person object`() {
        val src = Person("hyunsung", 30, "nanamare")
        val des = Person("hyunsung", 30, "nanamare")
        val people = listOf(
            Person("hyunsung", 30, "nanamare"),
            Person("hyunsung", 30, "nanamare"),
            Person("hyunsung", 30, "nanamare")
        )

        assertThat(src).satisfies {
            assertThat(src.name).isEqualTo(des.name)
            assertThat(src.age).isEqualTo(des.age)
            assertThat(src.nickname).isEqualTo(des.nickname)
        }

        assertThat(people).satisfies {
            assertThat(src.name).isEqualTo(des.name)
            assertThat(src.age).isEqualTo(des.age)
            assertThat(src.nickname).isEqualTo(des.nickname)
        }
    }

    @Test
    fun `Check nullable types`() {
        val person = Person("hyunsung", null, null)
        assertAll(
            { assertThat(person.name).isEqualTo("hyunsung") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }
}