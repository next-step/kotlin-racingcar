package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "Jay", age = 30, nickname = "제이")
        assertThat(person.name).isEqualTo("Jay")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isEqualTo("제이")
    }

    @Test
    fun `널 타입`() {
        val person = Person(name = "Jay", age = 30, nickname = null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "Jay", age = 30)
        assertThat(person.name).isEqualTo(person.nickname)
    }

    @Test
    fun `데이트 클래스`() {
        val person1 = Person("Jay", 30)
        val person2 = Person("Jay", 30)
        assertThat(person1).isEqualTo(person2)
    }
}
