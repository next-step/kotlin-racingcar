package study.kotlinBasic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val people = listOf<Person>(
            Person("이호재", 26, "그란델왈드"),
            Person("이호재", 26, nickname = "그란델왈드"),
            Person(name = "이호재", age = 26, nickname = "그란델왈드")
        )
        assertThat(people[0].name).isEqualTo("이호재")
        assertThat(people[1].name).isEqualTo("이호재")
        assertThat(people[2].name).isEqualTo("이호재")
    }

    @Test
    fun `널 타입`() {
        val person = Person("이호재", 26, null)
        assertThat(person.name).isEqualTo("이호재")
        assertThat(person.age).isEqualTo(26)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("이호재", 26)
        assertThat(person.name).isEqualTo("이호재")
        assertThat(person.age).isEqualTo(26)
        assertThat(person.nickname).isEqualTo("이호재")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("이호재", 26)
        val person2 = Person("이호재", 26)
        assertThat(person1).isEqualTo(person2)
    }
}

