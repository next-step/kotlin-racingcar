package racingcar.domain.car.vo

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class NameTest {
    @Test
    fun `이름은 빈 값이거나 5자보다 길 수 없음`() {
        assertThatThrownBy { Name("") }
            .isInstanceOf(IllegalArgumentException().javaClass)
    }

    @Test
    fun `이름은 5자보다 길 수 없음`() {
        assertThatThrownBy { Name("123456") }
            .isInstanceOf(IllegalArgumentException().javaClass)
    }

    @Test
    fun `이름 생성`() {
        val name = Name("제이")

        assertThat(name.value).isEqualTo("제이")
    }
}
