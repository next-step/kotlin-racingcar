package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙은 인자`() {
        val person = Person(name = "김대현", age = 28, nickname = "kimdh-hi")
        assertThat(person.name).isEqualTo("김대현")
        assertThat(person.age).isEqualTo(28)
        assertThat(person.nickname).isEqualTo("kimdh-hi")
    }

    @Test
    fun `널 허용`() {
        val person = Person(name = "김대현", age = 28, nickname = null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "김대현", age = 28)
        assertThat(person.nickname).isEqualTo("김대현")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "김대현", age = 28)
        val person2 = Person(name = "김대현", age = 28)
        assertThat(person1).isEqualTo(person2)
    }
}
