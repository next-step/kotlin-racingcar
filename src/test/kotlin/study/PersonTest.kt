package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person("김민경", 70, "Margot")
        assertThat(person.name).isEqualTo("김민경")
        assertThat(person.age).isEqualTo(70)
        assertThat(person.nickname).isEqualTo("Margot")
    }

    @Test
    fun `널 타입`() {
        val person = Person("김민경", 70, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("김민경", 70)
        assertThat(person.name).isEqualTo(person.nickname)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("김민경", 70)
        val person2 = Person("김민경", 70)

        assertThat(person1).isEqualTo(person2)
    }
}
