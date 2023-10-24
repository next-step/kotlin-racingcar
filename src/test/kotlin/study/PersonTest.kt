package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        // instead 자바 빌더 패턴
        val person = Person(name = "홍길동", age = 30, nickname = "홍")
        assertThat(person.name).isEqualTo("홍길동")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isEqualTo("홍")
    }

    @Test
    fun `null 타입`() {
        val person = Person(name = "홍길동", age = 30, nickname = null)
        assertThat(person.name).isEqualTo("홍길동")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "홍길동", age = 30)
        assertThat(actual.name).isEqualTo("홍길동")
        assertThat(actual.age).isEqualTo(30)
        assertThat(actual.name).isEqualTo("홍길동")
    }

    @Test
    fun `데이터 클래스`() {
        // data classs는 equals, hashCode, toString, copy 메서드를 자동으로 생성
        val person1 = Person(name = "홍길동", age = 20)
        val person2 = Person(name = "홍길동", age = 20)
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `copy`() {
        val person = Person(name = "홍길동", age = 20)
        val actual = person.copy(nickname = "홍")
        assertThat(actual.name).isEqualTo("홍길동")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("홍")
    }
}
