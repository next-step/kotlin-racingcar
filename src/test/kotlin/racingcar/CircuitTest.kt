package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CircuitTest {
    private val numberOfCar = 5
    private val circuit = Circuit().apply {
        repeat(numberOfCar) {
            addCarToCircuit(Car(4))
        }
    }

    @Test
    fun `차량 추가시 정상 작동 확인`() {
        assertThat(circuit.addCarToCircuit(Car(4))).isTrue
    }

    @Test
    fun `전체 차량 이동시 정상 작동 확인`() {
        assertThat(circuit.tryToMoveAllCar()).isEqualTo(Unit)
    }

    @Test
    fun `전체 차량 이동거리 받기 정상 작동 확인`() {
        assertThat(circuit.getAllCarsMoveDistance().size).isEqualTo(numberOfCar)
    }
}
