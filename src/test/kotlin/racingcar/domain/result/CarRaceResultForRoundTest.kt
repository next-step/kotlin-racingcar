package racingcar.domain.result

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.car.Car
import racingcar.domain.car.vo.Name
import racingcar.domain.car.vo.Position

class CarRaceResultForRoundTest {
    @Test
    fun `가장 앞선 차량을 확인`() {
        val first = Car(Name("제이"), Position(10))
        val second = Car(Name("제이슨"), Position(9))
        val third = Car(Name("포비"), Position(8))

        val carRaceResultForRound = CarRaceResultForRound(listOf(first, second, third))
        val winnersForRound = carRaceResultForRound.getWinnersForRound()

        assertThat(winnersForRound.size).isEqualTo(1)
        assertThat(winnersForRound[0].name).isEqualTo(first.name.value)
        assertThat(winnersForRound[0].position).isEqualTo(first.position.value)
    }

    @Test
    fun `가장 앞선 차량이 2대 이상일 수 있음`() {
        val first1 = Car(Name("제이"), Position(10))
        val first2 = Car(Name("제이슨"), Position(10))
        val third = Car(Name("포비"), Position(9))

        val carRaceResultForRound = CarRaceResultForRound(listOf(first1, first2, third))
        val winnersForRound = carRaceResultForRound.getWinnersForRound()

        assertThat(winnersForRound.size).isEqualTo(2)
        assertThat(winnersForRound[0].name).isEqualTo(first1.name.value)
        assertThat(winnersForRound[0].position).isEqualTo(first1.position.value)
        assertThat(winnersForRound[1].name).isEqualTo(first2.name.value)
        assertThat(winnersForRound[1].position).isEqualTo(first2.position.value)
    }
}
