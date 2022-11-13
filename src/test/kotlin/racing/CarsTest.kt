package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CarsTest {
    private lateinit var moveStrategy: MoveStrategy
    private lateinit var cars: Cars

    @BeforeEach
    fun init() {
        moveStrategy = MoveStrategy { true }
        cars = Cars.init(3, moveStrategy)
    }

    @Test
    fun `2회_진행_후_결과_검증`() {
        // given
        val expectedCars = Cars((0.until(3)).map { Car(moveStrategy = moveStrategy, distance = 2) })

        // when
        repeat(2) { cars.move() }

        // then
        assertEquals(cars, expectedCars)
    }

    @Test
    fun `3회_진행_후_움직인_거리_검증`() {
        // given
        val expectedCars = Cars((0.until(3)).map { Car(moveStrategy = moveStrategy, distance = 3) })

        // when
        repeat(3) { cars.move() }

        // then
        assertThat(cars.getDistances()).containsExactlyElementsOf(expectedCars.getDistances())
    }
}
