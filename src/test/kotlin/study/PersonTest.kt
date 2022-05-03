package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        Person("안경무", 29, "브랜")
        Person("안경무", 29, nickname = "브랜")
        Person(name = "안경무", age = 29, nickname = "브랜")
    }

    @Test
    fun `널 타입`() {
        val person = Person("안경무", 29, null)
        assertThat(person.name).isEqualTo("안경무")
        assertThat(person.age).isEqualTo(29)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("안경무", 29)
        assertThat(person.name).isEqualTo("안경무")
        assertThat(person.age).isEqualTo(29)
        assertThat(person.nickname).isEqualTo("안경무")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("안경무", 29)
        val person2 = Person("안경무", 29)
        assertThat(person1).isEqualTo(person2)
    }
}