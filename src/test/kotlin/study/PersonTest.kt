package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "강래민", age = 30, nickname = "래머")
        assertThat(person.name).isEqualTo("강래민")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isEqualTo("래머")
    }

    @Test
    fun `널 타입`() {
        val person = Person("강래민", 30, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("강래민", 30)
        assertThat(person.nickname).isEqualTo(person.name)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("강래민", 30)
        val person2 = Person("강래민", 30)
        assertThat(person1).isEqualTo(person2)
    }
}
