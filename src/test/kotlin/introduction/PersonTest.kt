package introduction

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "최정", age = 35, nickname = "namonak")
        assertThat(person.name).isEqualTo("최정")
        assertThat(person.age).isEqualTo(35)
        assertThat(person.nickname).isEqualTo("namonak")
    }

    @Test
    fun `널 타입`() {
        val person = Person(name = "최정", age = 35, nickname = null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "최정", age = 35)
        assertThat(person.name).isEqualTo(person.nickname)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "최정", age = 35)
        val person2 = Person(name = "최정", age = 35)
        assertThat(person1).isEqualTo(person2)
    }
}
