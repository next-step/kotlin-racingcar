package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val person = Person(
            name = "곽진규",
            age = 3,
            nickname = "JK",
        )
        assertThat(person.name).isEqualTo("곽진규")
        assertThat(person.age).isEqualTo(3)
        assertThat(person.nickname).isEqualTo("JK")
    }

    @Test
    fun `널 타입`() {
        val person = Person(
            name = "곽진규",
            age = 3,
            nickname = null,
        )
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person(
            name = "곽진규",
            age = 3,
        )
        assertThat(person.name).isEqualTo(person.nickname)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(
            name = "곽진규",
            age = 3
        )
        val person2 = Person(
            name = "곽진규",
            age = 3
        )
        assertThat(person1).isEqualTo(person2)
    }
}
