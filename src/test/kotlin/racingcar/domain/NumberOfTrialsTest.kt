package racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class NumberOfTrialsTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = ["-1", "0", "21", "a", "!", "?"])
    fun `잘못된 시도 횟수를 입력하면 IllegalArgumentException이 발생한다`(input: String?) {
        Assertions.assertThatThrownBy {
            NumberOfTrials.from(input?.toIntOrNull())
        }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 5, 10, 15, 20])
    fun `정상적인 시도 횟수 입력 테스트`(input: Int) {
        val numberOfTrials = NumberOfTrials.from(input)

        Assertions.assertThat(numberOfTrials.value).isEqualTo(input)
    }
}
