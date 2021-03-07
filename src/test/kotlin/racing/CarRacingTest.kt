package racing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarRacingTest {
    private val carRacing = CarRacing()

    @Test
    fun `차량 갯수와 repeat 횟수가 동일한지 확인한다`() {
        carRacing.execute(CAR_COUNT, TRY_COUNT)

        assertEquals(TRY_COUNT, carRacing.records.size)
        carRacing.records.forEach {
            assertEquals(CAR_COUNT, it.records.size)
        }
    }

    companion object {
        const val CAR_COUNT = 5
        const val TRY_COUNT = 7
    }
}
