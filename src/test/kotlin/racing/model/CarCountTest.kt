package racing.model

import io.kotest.matchers.nulls.shouldNotBeNull
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarCountTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 10, 30])
    fun `경주용 자동차가 0개 이상일 때`(count: Int) {
        CarCount(count).shouldNotBeNull()
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, -100])
    fun `경주용 자동차가 0개 이하일 때`(count: Int) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            CarCount(count).shouldNotBeNull()
        }
    }
}

internal class RoundCountTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 10, 30])
    fun `경주 시도할 횟수가 0번 이상일 때`(count: Int) {
        RoundCount(count).shouldNotBeNull()
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, -100])
    fun `경주 시도할 횟수가 0번 이하일 때`(count: Int) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            RoundCount(count).shouldNotBeNull()
        }
    }
}
