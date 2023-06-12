package step3.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step3.domain.strategy.AlwaysMoveCondition
import step3.domain.strategy.NeverMoveCondition

internal class RacingSimulatorTest {
    @Test
    internal fun `레이싱 테스트`() {
        // given : 항상 전진하는 car1과 항상 가만히 있는 car2가 참가하는 전진 시도 2인 레이싱 게임 준비
        val sut = RacingSimulator()
        val racingRequest = RacingRequest(
            cars = listOf(CarRequest("car1", AlwaysMoveCondition()), CarRequest("car2", NeverMoveCondition())),
            attemptCount = 2
        )

        // when : 레이싱 수행
        val racingRecord = sut.race(racingRequest)

        // then : size 2인 기록 반환
        assertThat(racingRecord.attempts.size).isEqualTo(2)
        // then : 경주의 우승자는 항상 전진하는 car1
        assertThat(racingRecord.winners).containsExactly("car1")
    }
}
