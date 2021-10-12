package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person1 = Person("tongnamuu", age = 25, nickname = "태형")
        assertThat(person1.name).isEqualTo("tongnamuu")
    }

    @Test
    fun `널 타입`() {
        val person1 = Person("tongnamuu", age = 25, null)
        assertThat(person1.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person1 = Person("Person1", age = 25, nickname = "nickname1")
        val person2 = Person("Person2", age = 35)
        assertThat(person1.nickname).isEqualTo("nickname1")
        assertThat(person2.nickname).isEqualTo("Person2")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("Person", age = 25, nickname = "nickname")
        val person2 = Person("Person", age = 25, nickname = "nickname")
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun 복사() {
        val person1 = Person("Person", age = 25, nickname = "nickname")
        val person2 = person1.copy(nickname = "changed nickname")
        assertThat(person1.name).isEqualTo(person2.name)
        assertThat(person1.age).isEqualTo(person2.age)
        assertThat(person1.nickname).isNotEqualTo(person2.nickname)
    }

}