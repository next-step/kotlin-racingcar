package racing

import org.assertj.core.api.Assertions.assertThat
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

    @ParameterizedTest
    @ValueSource(strings = ["abcde", "a", "bb", "ccd"])
    fun `자동차 이름 통과 테스트`(name: String) {
        val carName = Name(name)
        assertThat(carName.value).isEqualTo(name)
    }
}
