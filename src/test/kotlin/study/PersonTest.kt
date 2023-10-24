package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`(){
        val actual = Person(name="김도훈", age=20, nickname = "김")
        assertThat(actual.name).isEqualTo("김도훈")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("김")
    }

    @Test
    fun `널 타입`() {
        val actual = Person("김도훈", 20, null)
        assertThat(actual.name).isEqualTo("김도훈")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person("김도훈", 20)
        assertThat(actual.name).isEqualTo("김도훈")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("김도훈")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("김도훈", 20)
        val person2 = Person("김도훈", 20)
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `copy`() {
        val person = Person("김도훈", 20)
        assertThat(person.nickname).isEqualTo("김도훈")

        val actual = person.copy(nickname = "김")
        assertThat(actual.name).isEqualTo("김도훈")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("김")
    }
}
