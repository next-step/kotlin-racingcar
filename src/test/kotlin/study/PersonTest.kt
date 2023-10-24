package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "장효택", age = 26, nickname = "taek")
        assertThat(person.name).isEqualTo("장효택")
        assertThat(person.age).isEqualTo(26)
        assertThat(person.nickname).isEqualTo("taek")
    }

    @Test
    fun `널 타입`() {
        val person = Person(name = "장효택", age = 26, nickname = null)
        assertThat(person.name).isEqualTo("장효택")
        assertThat(person.age).isEqualTo(26)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "장효택", age = 26)
        assertThat(person.name).isEqualTo("장효택")
        assertThat(person.age).isEqualTo(26)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `데이터 클래스`() {
        val person = Person(name = "장효택", age = 26, nickname = "taek")
        val person2 = Person(name = "장효택", age = 26, nickname = "taek")
        assertThat(person.toString()).isEqualTo("Person(name=장효택, age=26, nickname=taek)")
        assertThat(person).isEqualTo(person2)
    }

    @Test
    fun `copy`() {
        val person = Person(name = "장효택", age = 26, nickname = "taek")
        val copiedPerson = person.copy(nickname = "Ari")
        assertThat(copiedPerson.name).isEqualTo("장효택")
        assertThat(copiedPerson.age).isEqualTo(26)
        assertThat(copiedPerson.nickname).isEqualTo("Ari")
    }
}
