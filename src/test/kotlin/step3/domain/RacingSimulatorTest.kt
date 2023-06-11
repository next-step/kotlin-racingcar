package step3.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingSimulatorTest {
    @Test
    internal fun `레이싱 테스트`() {
        // given : 자동차 수 2, 전진 시도 2인 레이싱 게임 준비
        val sut = RacingSimulator()
        val racingRequest = RacingRequest(carCount = 2, attemptCount = 2)

        // when : 레이싱 수행
        val racingRecord = sut.race(racingRequest)

        // then : size 2인 기록 반환
        assertThat(racingRecord.record.size).isEqualTo(2)
    }
}
