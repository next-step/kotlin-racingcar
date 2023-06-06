package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PersonTest {

    //백틱 ` 이용시 언더스코어 없어도 한글로 메서드 명 짓기 가능
    @Test
    internal fun `이름 붙인 인자`() {
        val actual = Person(name = "한맹희", age = 30, nickname = "맹귄")
        assertThat(actual.name).isEqualTo("한맹희")
        assertThat(actual.nickname).isEqualTo("맹귄")
        assertThat(actual.age).isEqualTo(30)
    }

    @Test
    internal fun `널 타입`() {
        val actual = Person(name = "한맹희", age = 30, nickname = null)
        assertThat(actual.nickname).isNull()
    }

    @Test
    internal fun `기본 인자`() {
        val actual = Person(name = "홍길동", age = 20)
        assertThat(actual.nickname).isEqualTo("Guest")
    }

    @Test
    internal fun `데이터 클래스`() {
        val person1 = Person("홍길동", 20, "Hong")
        val person2 = Person("홍길동", 20, "Hong")
        assertThat(person1).isEqualTo(person2)
    }
}
