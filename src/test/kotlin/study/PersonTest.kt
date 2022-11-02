package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(nickname = "윤", age = 20, name = "김윤수")
        assertThat(person.name).isEqualTo("김윤수")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isEqualTo("윤")
    }

    @Test
    fun `널 타입`() {
        val person = Person("김윤수", 20, null)
        assertAll(
            { assertThat(person.name).isEqualTo("김윤수") },
            { assertThat(person.age).isEqualTo(20) },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `기본 인자`() {
        val person = Person("김윤수", 20)
        assertThat(person.nickname).isEqualTo(person.name)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("김윤수", 20, "윤")
        val person2 = Person("김윤수", 20, "윤")
        assertThat(person1).isEqualTo(person2)
    }
}
