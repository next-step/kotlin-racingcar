package racing

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racing.exception.CarsNameException
import racing.domain.Names

class NamesTest {
    @Test
    fun `자동차 이름 입력 개수 에러 테스트`() {
        assertThrows<CarsNameException> {
            Names(listOf())
        }
    }
}
