package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        Person("나윤지", 29, "yj")
        Person("나윤지", 29, nickname = "yj")
        Person(name = "나윤지", age = 29, nickname = "yj")
    }

    @Test
    fun `널 타입`() {
        val person = Person("나윤지", 29, null)
        assertThat(person.name).isEqualTo("나윤지")
        assertThat(person.age).isEqualTo(29)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("나윤지", 29)
        assertThat(person.name).isEqualTo("나윤지")
        assertThat(person.age).isEqualTo(29)
        assertThat(person.nickname).isEqualTo("나윤지")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("나윤지", 29)
        val person2 = Person("나윤지", 29)
        assertThat(person1).isEqualTo(person2)
    }
}
