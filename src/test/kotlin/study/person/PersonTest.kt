package study.person

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import study.person.Person

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "홍길동", 20, nickname = "홍") // 같은 타입이 두번 나오는 경우, 이름을 붙여 주면 좋다.
        assertThat(actual.name).isEqualTo("홍길동") // 필드가 아니라 프로퍼티이기 때문에, getter 로 호출하는거다.
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("홍")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "홍길동", 20, nickname = null)
        assertThat(actual.name).isEqualTo("홍길동")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        // nickname 이 없는 경우, 이름을 nickname 에 넣어야.
        val actual = Person(name = "홍길동", 20)
        assertThat(actual.name).isEqualTo("홍길동")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("홍길동")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "홍길동", 20)
        val person2 = Person(name = "홍길동", 20)

        assertThat(person1).isEqualTo(person2)
        // java 에서 구현한다면, eqauls, hashcode 를 구현해야 한다.
    }

    @Test
    fun copy() {
        val person = Person(name = "홍길동", 20)
        assertThat(person.name).isEqualTo("홍길동")

        val actual = person.copy(nickname = "홍") // 내가 만들지 않은 copy 함수를 사용할 수 있다.
        assertThat(actual.name).isEqualTo("홍길동")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("홍")
    }
}
