package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.constant.Constant
import racingcar.model.Car
import racingcar.util.Engine
import racingcar.util.RacingUtil

class RacingCarTest {
    @Test
    fun `자동차가 전진하면 거리가 한칸 늘어나는가`() {
        assertEquals(Engine.forward(Car()), Car(Constant.ONE_SPACE))
    }

    @ParameterizedTest
    @CsvSource("1, 1", "2, 2", "3, 3")
    fun `입력받은 자동차 개수 만큼 리스트에 자동차가 생기는가`(input: Int, expected: Int) {
        val carListSize = RacingUtil.getCarList(input).size
        assertEquals(carListSize, expected)
    }
}
