package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racing.domain.Names
import racing.domain.vo.Name
import racing.exception.CarsNameException

class NamesTest {
    @Test
    fun `자동차 이름 입력은 0이하이면 실패한다`() {
        assertThrows<CarsNameException> {
            Names(listOf())
        }
    }

    @Test
    fun `자동차 이름 입력은 0보다 크면 통과한다`() {
        val names = Names(listOf(Name("A"), Name("B")))
        assertThat(names.names.size).isEqualTo(2)
    }
}
