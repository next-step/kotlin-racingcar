package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val person = Person(
            name = "김대연",
            age = 20,
            nickname = "dy"
        )

        assertThat(person.name).isEqualTo("김대연")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isEqualTo("dy")
    }

    @Test
    fun `널 타입`() {
        val person = Person("김대연", 20, null)

        assertAll(
            { assertThat(person.name).isEqualTo("김대연") },
            { assertThat(person.age).isEqualTo(20) },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `기본 인자`() {
        val person = Person("김대연", 20)

        assertAll(
            { assertThat(person.name).isEqualTo("김대연") },
            { assertThat(person.age).isEqualTo(20) },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `데이터 클래스`() {
        val person = Person("김대연", 20)
        val person2 = Person("김대연", 20)

        assertAll(
            { assertThat(person.name).isEqualTo("김대연") },
            { assertThat(person.age).isEqualTo(20) },
            { assertThat(person.nickname).isNull() },
            { assertThat(person).isEqualTo(person2) }
        )
    }
}
