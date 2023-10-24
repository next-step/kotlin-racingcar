package study

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

internal class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(nickname = "홍", name = "홍길동", age = 20)
        assertThat(person.name).isEqualTo("홍길동")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isEqualTo("홍")
    }

    @Test
    fun `널 타입`() {
        val person = Person(nickname = null, name = "홍길동", age = 20)
        assertThat(person.name).isEqualTo("홍길동")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "홍길동", age = 20)
        assertThat(person.name).isEqualTo("홍길동")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isEqualTo("홍길동")
    }

    @Test
    fun `data classes`() {
        val person = Person(name = "홍길동", age = 20)
        val person2 = Person(name = "홍길동", age = 20)
        assertThat(person).isEqualTo(person2)
    }

    @Test
    fun copy() {
        val person = Person(name = "홍길동", age = 20)
        val person2 = person.copy(nickname = "홍")
        assertThat(person2.name).isEqualTo("홍길동")
        assertThat(person2.nickname).isEqualTo("홍")
    }
}