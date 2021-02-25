package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class PersonTest {

    @Test
    fun `이름 붙인 인자`() { // named arguments
        val person1 = Person(name = "김수현", age = 21, nickname = "leah")
        assertThat(person1.name).isEqualTo("김수현")
        assertThat(person1.age).isEqualTo(21)
        assertThat(person1.nickname).isEqualTo("leah")

        val person2 = Person(nickname = "leah", name = "김수현", age = 21)
        assertThat(person2.name).isEqualTo("김수현")
        assertThat(person2.age).isEqualTo(21)
        assertThat(person2.nickname).isEqualTo("leah")
    }

    @Test
    fun `널 타입`() {
        val person = Person("김수현", 21, null)
        assertAll(
            { assertThat(person.name).isEqualTo("김수현") },
            { assertThat(person.age).isEqualTo(21) },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `기본 인자`() {
        val person = Person("김수현", 21)
        assertAll(
            { assertThat(person.name).isEqualTo("김수현") },
            { assertThat(person.age).isEqualTo(21) },
            { assertThat(person.nickname).isEqualTo("김수현") }
        )
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("김수현", 21, "leah")
        val person2 = Person("김수현", 21, "leah")
        assertThat(person1).isEqualTo(person2)
    }
}
