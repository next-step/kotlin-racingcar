import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class PersonTest {

    private lateinit var person: Person

    @BeforeEach
    fun setUp() {
        person = Person("최윤호", 29, null)
    }

    @Test
    fun `사람 객체의 이름을 확인`() {
        val expected = "최윤호"
        assertThat(person.name).isEqualTo(expected)
    }

    @Test
    fun `널 타입의 값을 확인`() {
        assertThat(person.nickname).isEqualTo(null)
    }

    @Test
    fun `데이터 클래스의 Equals 확인`() {
        val anotherPerson = Person("홍길동", 29, null)
        val samePerson = Person("최윤호", 29, null)

        val isSame = person == anotherPerson

        assertAll(
            { assertThat(isSame).isFalse() },
            { assertThat(samePerson).isEqualTo(person) }
        )
    }

    @Test
    fun `데이터 클래스 구조 분해 선언 동작 확인`() {
        val (name, age, nickname) = Person("최윤호", 29, null)

        assertAll(
            { assertThat(name).isEqualTo(person.name) },
            { assertThat(age).isEqualTo(person.age) },
            { assertThat(nickname).isEqualTo(person.nickname) }
        )
    }

    @Test
    fun `데이터 클래스 카피 기능`() {
        val anotherPerson = Person("최윤호", 29, null)

        assertThat(person.copy()).isEqualTo(anotherPerson)
    }
}