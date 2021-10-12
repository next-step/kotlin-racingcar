package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙은 인자`() {
        val person1 = Person("고정완", 20, "Pyro")
        val person2 = Person(nickname = "Pyro", name = "고정완", age = 20)
        assertThat(person1.name).isEqualTo(person2.name)
        assertThat(person1.age).isEqualTo(person2.age)
        assertThat(person1.nickname).isEqualTo(person2.nickname)
    }

    @Test
    fun `널 타입`() {
        val person = Person("고정완", 20, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `primary constructor`() {
        val person = Person("고정완", 20, "Pyro")
        assertThat(person.name).isEqualTo("고정완")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isEqualTo("Pyro")
    }

    @Test
    fun `secondary constructor, 기본 인자`() {
        val person = Person("고정완", 20)
        assertThat(person.nickname).isEqualTo("고정완")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("고정완", 20, "Pyro")
        val person2 = Person("고정완", 20, "Pyro")
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `복사`() {
        val person1 = Person("고정완", 20, "Pyro")
        val person2 = person1.copy(nickname = null)
        assertThat(person1.name).isEqualTo("고정완")
        assertThat(person1.age).isEqualTo(20)
        assertThat(person1.nickname).isEqualTo("Pyro")

        assertThat(person2.name).isEqualTo("고정완")
        assertThat(person2.age).isEqualTo(20)
        assertThat(person2.nickname).isEqualTo(null)
    }
}
