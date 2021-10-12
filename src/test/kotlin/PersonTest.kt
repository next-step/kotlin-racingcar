package study

import Person
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙은 인자`() {
        val personOne = Person("나채원", 31, "Che1")
        val personTwo = Person(name = "나채원", age = 31, nickname = "Che1")

        assertThat(personOne.name).isEqualTo(personTwo.name)
        assertThat(personOne.age).isEqualTo(personTwo.age)
        assertThat(personOne.nickname).isEqualTo(personTwo.nickname)
    }

    @Test
    fun `널 타입`() {
        val person = Person("나채원", 31, null)

        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("나채원", 31)

        assertThat(person.nickname).isEqualTo("나채원")
    }

    @Test
    fun `데이터 클래스`() {
        val personOne = Person("나채원", 31, "Che1")
        val personTwo = Person("나채원", 31, "Che1")

        assertThat(personOne).isEqualTo(personTwo)
    }

    @Test
    fun `복사`() {
        val personOne = Person("나채원", 31, "Che1")
        val personTwo = personOne.copy()

        assertThat(personOne).isEqualTo(personTwo)
    }
}
