package race

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class SimpleCarTest {
    @ParameterizedTest
    @ValueSource(strings = ["orange"])
    fun `name 정책위반 테스트`(name: String) {
        Assertions.assertThatThrownBy { SimpleCar(name) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다")
    }
}
