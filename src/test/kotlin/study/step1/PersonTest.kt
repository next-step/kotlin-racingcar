package study.step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("이상민", 10, "glenn"),
            Person("이상민", 10, nickname = "glenn"),
            Person(name = "이상민", age = 10, nickname = "glenn")
        )

        assertThat(people[0].name).isEqualTo("이상민")
        assertThat(people[1].name).isEqualTo("이상민")
        assertThat(people[2].name).isEqualTo("이상민")
//        assertThat(people).allSatisfy {
//            Consumer { assertThat(it.name).isEqualTo("이상민") }
//        }
    }

    @Test
    fun `널 타입`() {
        val person = Person("이상민", 10, null)
        assertThat(person.name).isEqualTo("이상민")
        assertThat(person.age).isEqualTo(10)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("이상민", 10)
        assertThat(person.name).isEqualTo("이상민")
        assertThat(person.age).isEqualTo(10)
        assertThat(person.nickname).isEqualTo("이상민")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("이상민", 10)
        val person2 = Person("이상민", 10)
        assertThat(person1).isEqualTo(person2)
    }
}
