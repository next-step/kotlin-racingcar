package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(
            name = "김이름",
            age = 20,
            nickname = "별명"
        )
        assertEquals("김이름", person.name)
        assertEquals(20, person.age)
        assertEquals("별명", person.nickname)
    }

    @Test
    fun `널 타입`() {
        val person = Person(
            name = "김이름",
            age = 20,
            nickname = null
        )
        assertEquals("김이름", person.name)
        assertEquals(20, person.age)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person(
            name = "김이름",
            age = 20,
        )
        assertEquals("김이름", person.name)
        assertEquals(20, person.age)
        assertEquals("김이름", person.nickname)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(
            name = "김이름",
            age = 20,
        )
        val person2 = Person(
            name = "김이름",
            age = 20,
        )
        assertEquals(person1, person2)
    }

    @Test
    fun copy() {
        val person1 = Person(
            name = "김이름",
            age = 20,
        )
        assertEquals(person1.nickname, "김이름")

        val person2 = person1.copy(nickname = "별명")
        assertEquals("김이름", person2.name)
        assertEquals(20, person2.age)
        assertEquals("별명", person2.nickname)
    }
}
