package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Car2Test {
    @Test
    fun `자동차 이름을 입력받고, 자동차 객체 생성 시 이름이 5자를 초과할 때, 예외를 던진다`() {
        // given :
        val name = "oyjoyj"
        val position = 0

        // when :
        val actual = runCatching { Car2(name = name, position = position) }.exceptionOrNull()

        // then :
        assertThat(actual).isInstanceOf(IllegalArgumentException::class.java)
    }
}
