package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "손진영", age = 29, nickname = "jysohn0825")
        assertThat(person.name).isEqualTo("손진영")
        assertThat(person.age).isEqualTo(29)
        assertThat(person.nickname).isEqualTo("jysohn0825")
    }

    @Test
    fun `널 타입`() {
        val person = Person(name = "손진영", age = 29, nickname = null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "손진영", age = 29)
        assertThat(person.nickname).isEqualTo(person.name)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "손진영", age = 29)
        val person2 = Person(name = "손진영", age = 29)
        assertThat(person1).isEqualTo(person2)
    }

}
