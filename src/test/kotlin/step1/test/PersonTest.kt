package step1.test

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step1.Person

class PersonTest {

    @Test
    fun `이름 테스트`() {
        Person("김광유", 30, "pang")
    }

    @Test
    fun `널 타입`() {
        val person = Person("김광유", 30, null)
        assertThat(person.name).isEqualTo("김광유")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 파라미터`() {
        val person = Person("김광유", 30)
        assertThat(person.name).isEqualTo("김광유")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isEqualTo("김광유")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("김광유", 30, "pang")
        val person2 = Person("김광유", 30, "pang")
        assertThat(person1).isEqualTo(person2)
    }
}
