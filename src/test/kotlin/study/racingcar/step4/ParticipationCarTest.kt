package study.racingcar.step4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import study.racingcar.step4.domain.ParticipationCars

internal class ParticipationCarTest {

    @Test
    fun `참가 경주차 개수 확인 Test`() {
        val carNameList = listOf("a", "b", "c")
        val participationCar = ParticipationCars(carNameList, 4)
        val racingCars = participationCar.cars
        assertThat(racingCars.size).isEqualTo(carNameList.size)
    }
}
