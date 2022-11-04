package step1.sutdy

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class PersonTest {
    @Test
    @DisplayName("이름 붙인 인자")
    internal fun `이름 붙인 인자`() {
        // Given
        val person = Person(name = "최용석", age = 32, nickname = "노엘")

        // When & Then
        assertThat(person.name).isEqualTo("최용석")
        assertThat(person.age).isEqualTo(32)
        assertThat(person.nickname).isEqualTo("노엘")
    }

    @Test
    @DisplayName("널 타입")
    internal fun `널 타입`() {
        // Given
        val person = Person(name = "최용석", age = 32, nickname = null)

        // When & Then
        assertThat(person.nickname).isNull()
    }

    @Test
    @DisplayName("기본 인자를 가지는 프로퍼티 생성자")
    internal fun `기본 인자를 가지는 프로퍼티 생성자`() {
        // Given
        val person = Person(name = "최용석", age = 32)

        // When & Then
        assertThat(person.nickname).isEqualTo(person.name)
    }

    @Test
    @DisplayName("데이터 클래스")
    internal fun `데이터 클래스`() {
        // Given
        val person1 = Person(name = "최용석", age = 32)
        val person2 = Person(name = "최용석", age = 32)

        // When & Then
        assertThat(person1).isEqualTo(person2)
    }
}
