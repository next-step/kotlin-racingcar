package racingcar.domain.car.engine

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.domain.car.Car

class EngineTest {
    @Test
    fun `전진하면 거리가 한칸 늘어난다`() {
        val engine = GoEngine()
        assertEquals(engine.forward(Car.READY_STATUS), Car.ONE_SPACE)
    }
}
