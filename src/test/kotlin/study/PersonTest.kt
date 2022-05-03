package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `널 타입`() {
        val person = Person("qyu", 34, null)
        assertThat(person.name).isEqualTo("qyu")
        assertThat(person.age).isEqualTo(34)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("qyu", 34)
        assertThat(person.name).isEqualTo("qyu")
        assertThat(person.age).isEqualTo(34)
        assertThat(person.nickname).isEqualTo("qyu")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("qyu", 34, null)
        val person2 = Person("qyu", 34, null)
        assertThat(person1).isEqualTo(person2)
    }
}