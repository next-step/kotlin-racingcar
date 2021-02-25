package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "정주영", age = 20, nickname = "ka0oll")
        assertThat(person.name).isEqualTo("정주영")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isEqualTo("ka0oll")

        val person2 = Person(name = "정주영", nickname = "ka0oll", age = 20)
        assertThat(person2.name).isEqualTo("정주영")
        assertThat(person2.age).isEqualTo(20)
        assertThat(person2.nickname).isEqualTo("ka0oll")
    }

    @Test
    fun `널 타입`() {
        val person = Person("정주영", 20, null)
        assertAll(
            { assertThat(person.name).isEqualTo("정주영") },
            { assertThat(person.age).isEqualTo(20) },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `기본 인자`() {
        val person = Person("정주영", 20)
        assertAll(
            { assertThat(person.name).isEqualTo("정주영") },
            { assertThat(person.age).isEqualTo(20) },
            { assertThat(person.nickname).isEqualTo("정주영") }
        )
    }

    @Test
    fun `데이더 클래스`() {
        val person1 = Person("정주영", 20)
        val person2 = Person("정주영", 20)
        assertThat(person1).isEqualTo(person2)
    }
}
