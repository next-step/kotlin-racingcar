package racingcar.filter

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ValueFilterTest {

    @ParameterizedTest
    @ValueSource(strings = ["10", "1111", "111241934", "2147483647"])
    fun `올바르게 값이 들어가는걸 테스트 한다 Exception 이 발생하면 안된다`(value: String) {
        assertThat(ValueFilter.verify(value)).isEqualTo(value.toInt())
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-10", "-2147483648"])
    fun `음수가 들어가면 Exception 이 발생한다`(value: String) {
        assertThrows<IllegalArgumentException> { ValueFilter.verify(value) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1a", "asofoaksad", "$@(!*@FADF"])
    fun `숫자가 아닌 값을 입력했을때를 테스트한다 Exception 발생`(value: String) {
        assertThrows<IllegalArgumentException> { ValueFilter.verify(value) }
    }
}
