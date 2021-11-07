package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.domain.car.Car
import racingcar.domain.car.engine.GoEngine

class EngineTest {
    @Test
    fun `전진하면 거리가 한칸 늘어난다`() {
        val engine = GoEngine()
        assertEquals(engine.forward(Car.READY_STATUS), Car.ONE_SPACE)
    }
}
