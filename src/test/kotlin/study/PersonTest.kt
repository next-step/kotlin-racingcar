package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "이범석", age = 26, nickname = "bmsk")
        assertThat(person.name).isEqualTo("이범석")
        assertThat(person.age).isEqualTo(26)
        assertThat(person.nickname).isEqualTo("bmsk")
    }

    @Test
    fun `널 타입`() {
        val person = Person("이범석", 26, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("이범석", 26)
        assertThat(person.name).isEqualTo("이범석")
        assertThat(person.nickname).isEqualTo("이범석")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("이범석", 26)
        val person2 = Person("이범석", 26)
        assertThat(person1 == person2).isTrue()
    }

    @Test
    fun copy() {
        val person = Person("이범석", 26)
        val person2 = person.copy(name = "이상혁")
        assertThat(person2.name).isEqualTo("이상혁")
        assertThat(person2.age).isEqualTo(26)
    }
}
