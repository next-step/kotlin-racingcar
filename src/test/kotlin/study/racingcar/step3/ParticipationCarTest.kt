package study.racingcar.step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class ParticipationCarTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 3, 5])
    fun `참가 경주차 개수 확인 Test`(count: Int) {
        val participationCar = ParticipationCar(count)
        val racingCars = participationCar.getRacingCars()
        assertThat(racingCars.size).isEqualTo(count)
    }
}
