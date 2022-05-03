package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
        Person("이광재",34,"제이"),
        Person("이광재",34, nickname = "제이"),
        Person(name = "이광재", age = 34, nickname = "제이")
        )
        assertThat(people[0].name).isEqualTo("이광재");
        assertThat(people[1].name).isEqualTo("이광재");
        assertThat(people[2].name).isEqualTo("이광재");
    }

    @Test
    fun `널 타입`() {
        val person = Person("이광재", 34, null)
        assertThat(person.name).isEqualTo("이광재")
        assertThat(person.age).isEqualTo(34)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("이광재", 34)
        assertThat(person.name).isEqualTo("이광재")
        assertThat(person.age).isEqualTo(34)
        assertThat(person.nickname).isEqualTo("이광재")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("이광재", 34)
        val person2 = Person("이광재", 34)
        assertThat(person1).isEqualTo(person2)
    }
}