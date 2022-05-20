package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racing.exception.CarsNameException
import racing.domain.Names
import racing.domain.vo.Name

class NamesTest {
    @Test
    fun `자동차 이름 입력 개수 에러 테스트`() {
        assertThrows<CarsNameException> {
            Names(listOf())
        }
    }

    @Test
    fun `자동차 이름 입력 개수 통과 테스트`() {
        val names = Names(listOf(Name("A"), Name("B")))
        assertThat(names.names.size).isEqualTo(2)
    }
}
