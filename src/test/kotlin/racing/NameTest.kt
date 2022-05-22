package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.domain.vo.Name
import racing.exception.CarNameException

class NameTest {
    @ParameterizedTest
    @ValueSource(strings = ["12345678", "123456", "", " "])
    fun `자동차의 이름은 1글자 이상 5글자 이하가 아니면 실패한다`(name: String) {
        assertThrows<CarNameException> { Name(name) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["abcde", "a", "bb", "ccd"])
    fun `자동차 이름은 1글자 이상 5글자 이하일 때 통과한다`(name: String) {
        val carName = Name(name)
        assertThat(carName.value).isEqualTo(name)
    }
}
