package study.junit

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import study.Person

class PersonTest {
    @Test
    fun `이름_붙인_인자`() {
        val people = listOf(
            Person("김정욱", 28, "hue"),
            Person("김정욱", 28, nickname = "hue"),
            Person(name = "김정욱", age = 28, nickname = "hue"),
        )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("김정욱")
            assertThat(it.age).isEqualTo(28)
            assertThat(it.nickname).isEqualTo("hue")
        }
    }

    @Test
    fun `널 타입`() {
        val person = Person("김정욱", null, null)
        assertAll(
            { assertThat(person.name).isEqualTo("김정욱") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() },
        )
    }

    @Test
    fun `기본 인자`() {
        val person = Person("김정욱")
        assertAll(
            { assertThat(person.name).isEqualTo("김정욱") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() },
        )
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("김정욱", 28, "hue")
        val person2 = Person("김정욱", 28, "hue")
        assertThat(person1).isEqualTo(person2)
    }
}
