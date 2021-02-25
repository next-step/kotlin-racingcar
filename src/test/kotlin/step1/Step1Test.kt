package step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class Step1Test {
    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("김광수", 29, "킷"),
            Person("김광수", 29, nickname = "킷"),
            Person(name = "김광수", nickname = "킷", age = 29)
        )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("김광수")
            assertThat(it.age).isEqualTo(29)
            assertThat(it.nickname).isEqualTo("킷")
        }
    }

    @Test
    fun `널 타입`() {
        val person = Person("김광수", null, null)
        assertAll(
            { assertThat(person.name).isEqualTo("김광수") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `기본인자`() {
        val person = Person("김광수")
        assertAll(
            { assertThat(person.name).isEqualTo("김광수") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("김광수", 29, "킷")
        val person2 = Person("김광수", 29, "킷")
        assertThat(person1).isEqualTo(person2)
    }
}
