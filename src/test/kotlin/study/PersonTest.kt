package study

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 있는 인자`() {
        // given
        val person1 = Person("김주열", 25, "juice")
        val person2 = Person("김주열", 25, nickName = "juice")
        val person3 = Person(name = "김주열", age = 25, nickName = "juice")
    }

    @Test
    fun `널 타입`() {
        // given
        val person = Person("김주열", 25, null)

        // when
        assertThat(person.name).isEqualTo("김주열")
        assertThat(person.age).isEqualTo(25)
        assertThat(person.nickName).isNull()
    }

    @Test
    fun `기본값`() {
        // given
        val person = Person("김주열", 25, null)

        // when
        assertThat(person.name).isEqualTo("김주열")
        assertThat(person.age).isEqualTo(25)
    }

    @Test
    fun `데이터 클래스`() {
        // given
        val person1 = Person("김주열", 25, null)
        val person2 = Person("김주열", 25, null)

        // when
        assertThat(person1).isEqualTo(person2)
    }
}
