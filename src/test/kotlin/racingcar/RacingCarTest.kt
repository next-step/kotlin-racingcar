package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.car.CarFactory
import racingcar.constant.Constant
import racingcar.engine.RandomEngine

class RacingCarTest {
    @Test
    fun `전진하면 거리가 한칸 늘어나는가`() {
        val engine = RandomEngine()
        assertEquals(engine.forward(Constant.READY_STATUS), Constant.ONE_SPACE)
    }

    @ParameterizedTest
    @CsvSource("1, 1", "2, 2", "3, 3")
    fun `입력받은 자동차 개수 만큼 리스트에 자동차가 생기는가`(input: Int, expected: Int) {
        val cars = CarFactory.create(input)
        val carListSize = cars.getCarList().size
        assertEquals(carListSize, expected)
    }
}
