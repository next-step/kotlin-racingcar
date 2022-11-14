package src.basic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "김영석", age = 29, nickname = "bread")

        assertThat(person.name).isEqualTo("김영석")
        assertThat(person.age).isEqualTo(29)
        assertThat(person.nickname).isEqualTo("bread")
    }

    @Test
    fun `널 타입`() {
        val person = Person(name = "김영석", age = 29, nickname = null)

        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "김영석", age = 29)

        assertThat(person.nickname).isEqualTo("bread")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "김영석", age = 29, nickname = "bread")
        val person2 = Person(name = "김영석", age = 29, nickname = "bread")

        assertThat(person1).isEqualTo(person2)
    }
}
