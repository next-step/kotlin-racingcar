package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.Circuit

class CircuitTest {
    private val numberOfCar = 5
    private val circuit = Circuit().apply {
        repeat(numberOfCar) {
            addCarToCircuit(Car(4))
        }
    }

    @Test
    fun `새차량을 추가시 결과값으로 True를 반환한다`() {
        assertThat(circuit.addCarToCircuit(Car(4))).isTrue
    }

    @Test
    fun `전체 차량 이동시 정상 작동 확인`() {
        assertThat(circuit.tryToMoveAllCar()).isEqualTo(Unit)
    }

    @Test
    fun `전체 차량의 LapResult를 요청시의 갯수가 전체 차량수와 동일 한지 확인한다`() {
        assertThat(circuit.getAllCarsLapResult().size).isEqualTo(numberOfCar)
    }
}
