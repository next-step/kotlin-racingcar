package racing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarRacingTest {
    private val cars = listOf(Car("서진혁"), Car("카샤"), Car("nextstep"))
    private val carRacing = CarRacing(cars, TRY_COUNT)

    @Test
    fun `차량 댓수와 repeat 횟수가 동일한지 확인한다`() {
        carRacing.execute()

        assertEquals(CAR_COUNT, cars.size)
        cars.forEach {
            assertEquals(TRY_COUNT, it.records.size)
        }
    }

    companion object {
        const val CAR_COUNT = 3
        const val TRY_COUNT = 7
    }
}
