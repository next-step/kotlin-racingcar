package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "박유진", age = 26, nickname = "yuuuzzzin")
        assertThat(person.name).isEqualTo("박유진")
        assertThat(person.age).isEqualTo(26)
        assertThat(person.nickname).isEqualTo("yuuuzzzin")
    }

    @Test
    fun `널 타입`() {
        val person = Person(name = "박유진", age = 26, nickname = null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "박유진", age = 26)
        assertThat(person.name).isEqualTo(person.nickname)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "박유진", age = 26)
        val person2 = Person(name = "박유진", age = 26)
        assertThat(person1).isEqualTo(person2)
    }
}
