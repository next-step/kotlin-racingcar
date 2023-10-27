package study.racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class DistanceTest {

    @Test
    fun `객체 생성시 기본 거리값이 0으로 생성된다`() {
        assertThat(Distance().getDistance()).isEqualTo(0)
    }

    @ParameterizedTest
    @MethodSource("moveDistanceProvider")
    fun `전진 횟수만큼 거리가 1이 증가한다`(
        moveForwardCount: Int,
        expectedDistance: Int
    ) {
        // Given
        val actual = Distance()

        // When
        for (index in 1..moveForwardCount) {
            actual.moveForward()
        }

        // Then
        assertThat(actual.getDistance()).isEqualTo(expectedDistance)
    }

    companion object {
        @JvmStatic
        fun moveDistanceProvider() = listOf(
            Arguments.of(1, 1),
            Arguments.of(10, 10),
            Arguments.of(100, 100),
        )
    }
}
