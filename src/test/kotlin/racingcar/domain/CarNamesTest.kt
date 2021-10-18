package racingcar.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class CarNamesTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = [" ", "    "])
    fun `잘못된 자동차 이름들을 입력하면 IllegalArgumentException이 발생한다`(input: String?) {
        Assertions.assertThatThrownBy {
            CarNames.from(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "ab", "abcd", "abcde"])
    fun `경주에 참가하는 자동차가 1대인 자동차 이름 입력 라인 테스트`(input: String) {
        val carNames = CarNames.from(input)

        assertThat(carNames).isNotNull
        assertThat(carNames.getCarNames()).isNotNull
        assertThat(carNames.size()).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(strings = ["a,b", "a, b", "ab,cd", "ab, cd", "abc,def", "abc, def", "abcd,efgh", "abcde,fghij", "abcde, fghij"])
    fun `경주에 참가하는 자동차가 2대인 자동차 이름 입력 라인 테스트`(input: String) {
        val carNames = CarNames.from(input)

        assertThat(carNames).isNotNull
        assertThat(carNames.getCarNames()).isNotNull
        assertThat(carNames.size()).isEqualTo(2)
    }

    @ParameterizedTest
    @ValueSource(strings = ["a,b,c", "a, b,  c", "a,b,c,d", "a, b, c,   d", "a,b,c,d,e", "a, b, c, d, e"])
    fun `경주에 참가하는 자동차가 3대 이상인 자동차 이름 입력 라인 테스트`(input: String) {
        val carNames = CarNames.from(input)

        assertThat(carNames).isNotNull
        assertThat(carNames.getCarNames()).isNotNull
        assertThat(carNames.size()).isGreaterThanOrEqualTo(3)
    }
}
