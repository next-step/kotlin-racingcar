package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val person = Person("김현준", 20, "larry")

        assertThat(person.name).isEqualTo("김현준")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isEqualTo("larry")
    }

    @Test
    fun `널 타입`() {
        val person = Person("김현준", 20, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("김현준", 20)
        assertThat(person.nickname).isEqualTo("Guest")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("김현준", 20, "larry")
        val person2 = Person("김현준", 20, "larry")
        assertThat(person1).isEqualTo(person2)
    }
}
