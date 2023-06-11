package step3.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CarTest {
    @ParameterizedTest
    @CsvSource(
        "1, 0",
        "2, 0",
        "3, 0",
        "4, 1",
        "5, 1",
        "6, 1",
    )
    internal fun `무작위 값이 4 이상일 경우 전진`(randomValue: Int, expectedPosition: Int) {
        // given : 최초 위치가 0인 자동차 준비
        val sut = Car()
        // when : 무작위 값이 4이상 일때 전진 시도
        sut.move(randomValue)
        // then : 전진 성공시 position 1 아니면 position 0
        assertThat(sut.position).isEqualTo(expectedPosition)
    }
}
