package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "김세윤", age = 30, nickname = "마르코")
        assertAll(
            "person",
            { assertThat(person.name).isEqualTo("김세윤") },
            { assertThat(person.age).isEqualTo(30) },
            { assertThat(person.nickname).isEqualTo("마르코") }
        )
    }

    @Test
    internal fun `널 타입`() {
        val person = Person("김세윤", 30, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    internal fun `기본 인자`() {
        val person = Person("김세윤", 30)
        assertThat(person.name).isEqualTo(person.nickname)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("김세윤", 30)
        val person2 = Person("김세윤", 30)
        assertThat(person1).isEqualTo(person2)
    }
}
