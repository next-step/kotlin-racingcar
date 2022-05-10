package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

@Test
fun `nullable types`() {
    val person = Person("이재영", 11, null)
    assertAll(
        { assertThat(person.name).isEqualTo("박재성") },
        { assertThat(person.age).isNull() },
        { assertThat(person.nickname).isNull() }
    )
}

@Test
fun `data classes`() {
    val person1 = Person("이재영", 12, "제이")
    val person2 = Person("이재영", 12, "제이")
    assertThat(person1).isEqualTo(person2)
}
