package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceTest {
    private val circuit = Circuit().apply {
        addCarToCircuit(Car(4))
    }

    @Test
    fun `Circuit에 차가 1개 이상 있을 시 startLap 정상작동 확인`() {
        assertThat(Race.startLap(circuit)).isEqualTo(Unit)
        circuit.addCarToCircuit(Car(4))
        assertThat(Race.startLap(circuit)).isEqualTo(Unit)
    }

    @Test
    fun `Circuit에 차가 없을 시 startLap 정상작동 확인`() {
        assertThat(Race.startLap(Circuit())).isEqualTo(Unit)
    }
}
