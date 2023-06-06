package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val person = Person("김태정", 20, "검프")
        assertThat(person.name).isEqualTo("김태정")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isEqualTo("검프")
    }

    @Test
    fun `널 타입`() {
        val person = Person("김태정", 20, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("김태정", 20)
        assertThat(person.nickname).isEqualTo("Guest")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("김태정", 20, "검프")
        val person2 = Person("김태정", 20, "검프")
        assertThat(person1).isEqualTo(person2)
    }
}
