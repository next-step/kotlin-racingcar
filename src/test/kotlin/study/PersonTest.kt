package study

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val person1 = Person(name = "Ahn", age = 29, nickname = "ssibongee")
        val person2 = Person(nickname = "ssibongee", age = 29, name = "Ahn")

        assertThat(person1.name).isEqualTo(person2.name)
        assertThat(person1.age).isEqualTo(person2.age)
        assertThat(person1.nickname).isEqualTo(person2.nickname)
    }

    @Test
    fun `null 타입`() {
        val person = Person("Ahn", 29, null)

        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("Ahn", 29)

        assertThat(person.nickname).isEqualTo("Ahn")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "Ahn", age = 29, nickname = "ssibongee")
        val person2 = Person(name = "Ahn", age = 29, nickname = "ssibongee")

        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `복사`() {
        val person1 = Person(name = "Ahn", age = 29, nickname = "ssibongee")
        val person2 = person1.copy(nickname = null)

        assertThat(person1.nickname).isEqualTo("ssibongee")
        assertThat(person2.nickname).isNull()
    }
}
