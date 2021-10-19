package racingcar.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class CarNameTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = ["abcdef", "abcdefgh", "ab c d"])
    fun `잘못된 자동차 이름을 입력하면 IllegalArgumentException이 발생한다`(input: String?) {
        Assertions.assertThatThrownBy {
            CarName.from(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "ab", "abc", "abcd", "abcde"])
    fun `정상적인 자동차 이름 입력 테스트`(input: String) {
        val carName = CarName.from(input)

        assertThat(carName.value).isEqualTo(input)
    }
}
