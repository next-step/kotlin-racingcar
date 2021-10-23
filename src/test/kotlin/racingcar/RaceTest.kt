package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest {

    @Test
    fun `Circuit에 차가 1개 이상 있을 시 startRace 실행 후 예외가 발생하는지 확인 한다`() {
        val circuit = Circuit().apply {
            addCarToCircuit(Car(4))
        }
        assertThat(Race.startRace(circuit, 1)).isEqualTo(Unit)
        circuit.addCarToCircuit(Car(4))
        assertThat(Race.startRace(circuit, 1)).isEqualTo(Unit)
    }

    @Test
    fun `Circuit에 차가 없을 시 startRace 실행 후 예외가 발생하지 않는지 확인한다`() {
        assertThat(Race.startRace(Circuit(), 1)).isEqualTo(Unit)
    }

    @Test
    fun `getWinnerNameList winner 하나 일시 정상작동 확인`() {
        val winnerCar = Car(4, "Win").apply { move(4) }
        val car = Car(4, "car")
        val circuit = Circuit().apply {
            addCarToCircuit(winnerCar)
            addCarToCircuit(car)
        }
        assertThat(Race.getWinnerNameList(circuit)).contains("Win")
    }

    @Test
    fun `getWinnerNameList winner 둘 이상일시 정상작동 확인`() {
        val winnerCar = Car(4, "Win").apply { move(4) }
        val winnerCar2 = Car(4, "Win2").apply { move(4) }
        val car = Car(4, "car")
        val circuit = Circuit().apply {
            addCarToCircuit(winnerCar)
            addCarToCircuit(winnerCar2)
            addCarToCircuit(car)
        }
        assertThat(Race.getWinnerNameList(circuit)).contains("Win", "Win2")
    }
}
