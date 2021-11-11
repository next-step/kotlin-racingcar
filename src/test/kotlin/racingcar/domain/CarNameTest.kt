package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarNameTest {

    @Test
    fun `자동차 이름 길이 체크`() {
        assertThrows<IllegalArgumentException> {
            CarName("가나다라마바사")
        }
    }

    @Test
    fun `자동차 이름이 빈값으로 들어오는지 체크`() {
        assertThrows<IllegalArgumentException> {
            CarName("")
        }
    }

    @Test
    fun `green case`() {
        val actual = CarName("가나다")
        assertThat(actual.name).isEqualTo("가나다")
    }
}
