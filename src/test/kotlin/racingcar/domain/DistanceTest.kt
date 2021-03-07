package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
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

    @Test
    fun `거리 합`() {
        val distance = Distance(2).plus(Distance(1))
        assertThat(distance).isEqualTo(Distance(3))
    }
}
