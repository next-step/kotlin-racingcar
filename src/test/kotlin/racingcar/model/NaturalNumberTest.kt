package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class NaturalNumberTest {

    @Test
    fun `자연수 생성에 성공한다`() {
        val naturalNumber = NaturalNumber.createNaturalNumber(1)
        assertThat(naturalNumber.number).isEqualTo(1)
    }

    @Test
    fun `0이하의 수가 인자로 들어오면 오류를 반환한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            NaturalNumber.createNaturalNumber(0)
        }
    }
}
