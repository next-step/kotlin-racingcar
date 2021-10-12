package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person1 = Person(name = "김세현", age = 27, nickname = "sinoso")
        val person2 = Person(age = 27, name = "김세현", nickname = "sinoso")
        assertThat(person1.name).isEqualTo(person2.name)
        assertThat(person1.age).isEqualTo(person2.age)
        assertThat(person1.nickname).isEqualTo(person2.nickname)
    }

    @Test
    fun `널 타입`() {
        val person = Person("김세현", 27, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("김세현", 27)
        assertThat(person.nickname).isEqualTo(person.name)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("김세현", 27, "sinoso")
        val person2 = Person("김세현", 27, "sinoso")
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `복사`() {
        val person1 = Person("김세현", 27, "sinoso")
        val person2 = person1.copy(nickname = null)
        assertThat(person1.nickname).isEqualTo("sinoso")
        assertThat(person2.nickname).isNull()
    }
}
