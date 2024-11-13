package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun testNameParameters() {
        val actual = Person(age = 20, name = "닭대가리", nickname = "박찬희")

        assertThat(actual.nickname).isEqualTo("박찬희")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.name).isEqualTo("닭대가리")
    }

    @Test
    fun testNullType() {
        val actual = Person(age = 20, name = "닭대가리", nickname = null)

        assertThat(actual.nickname).isNull() 
    }

    @Test
    fun testDefaultParameters() {
        val actual = Person(age = 20, name = "닭대가리")

        assertThat(actual.nickname).isEqualTo("닭대가리")
    }

    @Test
    fun testDataclass() {
        val person1 = Person(age = 20, name = "닭대가리", nickname = "박찬희")
        val person2 = Person(age = 20, name = "닭대가리", nickname = "박찬희")

        assertThat(person1).isEqualTo(person2)
    }
}
