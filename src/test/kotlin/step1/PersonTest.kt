package step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름있는 아규먼트`() {
        val people = listOf(
            Person("홍길동", 10, "hong"),
            Person("홍길동", 10, nickname = "hong"),
            Person(name = "홍길동", nickname = "hong", age = 10)
        )

        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("홍길동")
            assertThat(it.age).isEqualTo(10)
            assertThat(it.nickname).isEqualTo("hong")
        }
    }

    @Test
    fun `널 타입`() {
        val person = Person("홍길동", 10, null)
        assertAll(
            { assertThat(person.name).isEqualTo("홍길동") },
            { assertThat(person.age).isEqualTo(10) },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `기본 인자`() {
        val person = Person("홍길동")
        assertAll(
            { assertThat(person.name).isEqualTo("홍길동") },
            { assertThat(person.age).isEqualTo(10) },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("홍길동")
        val person2 = Person("홍길동")
        assertThat(person1).isEqualTo(person2)
    }
}
