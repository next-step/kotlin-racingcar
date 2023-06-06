package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    // 백틱 가능
    fun `이름 붙인 인자`() {
//        Person("문창주", 19, "pooh")
        // 이렇게 명시적으로도 가능
        val actual: Person = Person(name = "문창주", age = 19, nickname = "pooh")
        assertThat(actual.name).isEqualTo("문창주")
        assertThat(actual.age).isEqualTo(19)
        assertThat(actual.nickname).isEqualTo("pooh")
    }

    @Test
    fun `널 타입`(){
            val actual = Person(name = "문창주", age = 19, nickname = null)
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "문창주", age = 20)
        assertThat(actual.nickname).isEqualTo("Guest")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("홍길동", 20, "Hong")
        val person2 = Person("홍길동", 20, "Hong")
        assertThat(person1).isEqualTo(person2)
    }
}