package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.Circuit
import racingcar.domain.Race

class RaceTest {

    @Test
    fun `Circuit에 차가 1개 이상 있을 시, startRace 함수를 호출하면 Race 결과를 리턴한다`() {
        val circuit = Circuit().apply {
            addCarToCircuit(Car(0))
        }
        val actual = Race.startRace(circuit, 1)
        assertThat(actual).containsAnyOf("NONE : -")
    }

    @Test
    fun `Circuit에 차가 없을 시, startRace 함수를 호출하면 빈 문자열 리스트로 반환 된다`() {
        val expectedElement = ""
        val actual = Race.startRace(Circuit(), 1)
        assertThat(actual).containsExactly(expectedElement)
    }

    @Test
    fun `getWinnerNameList winner 하나 일시 정상작동 확인`() {
        val winnerCar = Car(4, "Win").apply { moveToForward(4) }
        val car = Car(4, "car")
        val circuit = Circuit().apply {
            addCarToCircuit(winnerCar)
            addCarToCircuit(car)
        }
        assertThat(Race.getWinnerNameList(circuit)).contains("Win")
    }

    @Test
    fun `getWinnerNameList winner 둘 이상일시 정상작동 확인`() {
        val winnerCar = Car(4, "Win").apply { moveToForward(4) }
        val winnerCar2 = Car(4, "Win2").apply { moveToForward(4) }
        val car = Car(4, "car")
        val circuit = Circuit().apply {
            addCarToCircuit(winnerCar)
            addCarToCircuit(winnerCar2)
            addCarToCircuit(car)
        }
        assertThat(Race.getWinnerNameList(circuit)).contains("Win", "Win2")
    }
}
