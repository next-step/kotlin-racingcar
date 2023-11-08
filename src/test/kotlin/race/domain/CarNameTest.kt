package race.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import race.domain.CarName.Companion.NAME_MAX_LENGTH
import java.lang.IllegalArgumentException

class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = ["orange", "pineapple"])
    fun `name 최대길이 정책위반시 exception throw`(name: String) {
        Assertions.assertThatThrownBy { CarName(name) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("자동차 이름은 ${NAME_MAX_LENGTH}자를 초과할 수 없습니다")
    }
}
