package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun name() {
        val person1 = Person("이정배", 20, "증배")
        val person2 = Person(nickname = "증배", name = "이정배", age = 20)
        assertThat(person1.name).isEqualTo(person2.name)
        assertThat(person1.age).isEqualTo(person2.age)
        assertThat(person1.nickname).isEqualTo(person2.nickname)
    }

    @Test
    fun `널 타입`() {
        val person = Person("이정배", 20, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("이정배", 20)
        assertThat(person.nickname).isEqualTo("이정배")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("이정배", 20, "증배")
        val person2 = Person(nickname = "증배", name = "이정배", age = 20)
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `복사`() {
        val person1 = Person("이정배", 20, "증배")
        val person2 = person1.copy(nickname = null)
        assertThat(person1.nickname).isEqualTo("증배")
        assertThat(person2.nickname).isNull()
    }
}
