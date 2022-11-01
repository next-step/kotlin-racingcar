package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "shin", age = 20, nickname = "shinaaaa")
        assertThat(person.name).isEqualTo("shin")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isEqualTo("shinaaaa")
    }

    @Test
    fun `널 타입`() {
        val person = Person(name = "shin", age = 20, nickname = null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "shin", age = 20)
        assertThat(person.name).isEqualTo(person.nickname)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "shin", age = 20)
        val person2 = Person(name = "shin", age = 20)
        assertThat(person1).isEqualTo(person2)
    }
}
