package racingcar.domain

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class DistanceTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4])
    fun `생성 테스트`(value: Int) {
        assertDoesNotThrow { Distance(value) }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, -2])
    fun `생성 테스트 0 보다 작은 경우 예외 처리`(value: Int) {
        assertThrows<IllegalArgumentException> { Distance(value) }
    }
}
