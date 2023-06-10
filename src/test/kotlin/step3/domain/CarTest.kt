package step3.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarTest {
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6])
    internal fun `무작위 값이 4 이상일 경우 전진`(randomValue: Int) {
        // given : 최초 위치가 0인 자동차 준비
        val sut = Car()
        // when : 무작위 값이 4이상 일때 전진 시도
        sut.move(randomValue)
        // then : 전진 성공, 위치 1로 변경
        assertThat(sut.position).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    internal fun `무작위 값이 4 미만일 경우 전진 실패`(randomValue: Int) {
        // given : 최초 위치가 0인 자동차 준비
        val sut = Car()
        // when : 무작위 값이 4 미만일때 전진 시도
        sut.move(randomValue)
        // then : 전진 실패, 위치 0
        assertThat(sut.position).isEqualTo(0)
    }
}
