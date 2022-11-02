package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "신성수", age = 28, nickname = "shinseongsu")
        assertThat(person.name).isEqualTo("신성수")
        assertThat(person.age).isEqualTo(28)
        assertThat(person.nickname).isEqualTo("shinseongsu")
    }

    @Test
    fun `널 타입`() {
        val person = Person(name = "신성수", age = 28, nickname = null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "신성수", age = 28)
        assertThat(person.name).isEqualTo(person.nickname)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("신성수", 28)
        val person2 = Person("신성수", 28)
        assertThat(person1).isEqualTo(person2)
    }
}
