package racing

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.exception.CarNameException
import racing.domain.vo.Name

class NameTest {
    @ParameterizedTest
    @ValueSource(strings = ["12345678", "123456", "", " "])
    fun `자동차 이름 에러 테스트`(name: String) {
        assertThrows<CarNameException> { Name(name) }
    }
}
