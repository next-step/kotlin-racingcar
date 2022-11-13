package racing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `자동차가_움직이는_경우`() {
        // given
        val moveStrategy = MoveStrategy { true }
        val car = Car(moveStrategy = moveStrategy)
        val expectedCar = Car(moveStrategy = moveStrategy, distance = 1)

        // when
        car.move()

        // then
        assertEquals(car, expectedCar)
    }

    @Test
    fun `자동차가_움직이지_않는_경우`() {
        // given
        val moveStrategy = MoveStrategy { false }
        val car = Car(moveStrategy = moveStrategy)
        val expectedCar = Car(moveStrategy = moveStrategy, distance = 0)

        // when
        car.move()

        // then
        assertEquals(car, expectedCar)
    }
}
