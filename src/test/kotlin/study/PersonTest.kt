package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class PersonTest {
    private val name = "sangwon"
    private val age = 35
    private val nickname = "hy43"
    private val defaultNickName = "guest"

    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = name, age = age, nickname = nickname)
        assertAll(
            { assertThat(person.name).isEqualTo(name) },
            { assertThat(person.age).isEqualTo(age) },
            { assertThat(person.nickname).isEqualTo(nickname) }
        )
    }

    @Test
    fun `널 타입`() {
        val person = Person(name = name, age = age, nickname = null)
        assertAll(
            { assertThat(person.name).isEqualTo(name) },
            { assertThat(person.age).isEqualTo(age) },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `기본 타입`() {
        val person = Person(name, age)
        assertAll(
            { assertThat(person.name).isEqualTo(name) },
            { assertThat(person.age).isEqualTo(age) },
            { assertThat(person.nickname).isEqualTo(defaultNickName) }
        )
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name, age, nickname)
        val person2 = Person(name, age, nickname)
        assertThat(person1).isEqualTo(person2)
    }
}
