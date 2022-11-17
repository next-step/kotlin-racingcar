package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CarsTest {
    private val moveStrategy = MoveStrategy { true }
    private lateinit var movableCarUserNames: List<Name>
    private lateinit var movableCars: List<Car>

    @BeforeEach
    fun init() {
        movableCarUserNames = listOf(Name.of("tobi"), Name.of("tom"))
        movableCars = movableCarUserNames.map { Car(moveStrategy = moveStrategy, name = it) }
    }

    @Test
    fun `2회_진행_후_결과_검증`() {
        // given
        val cars = Cars(movableCars)
        val expectedCars = Cars(movableCarUserNames.map { Car(moveStrategy = moveStrategy, distance = 2, name = it) })

        // when
        repeat(2) { cars.move() }

        // then
        assertEquals(cars, expectedCars)
    }

    @Test
    fun `3회_진행_후_움직인_거리_검증`() {
        // given
        val cars = Cars(movableCars)
        val expectedCars = Cars(movableCarUserNames.map { Car(moveStrategy = moveStrategy, distance = 3, name = it) })

        // when
        repeat(3) { cars.move() }

        // then
        assertThat(cars.getDistancesWithNames()).containsExactlyElementsOf(expectedCars.getDistancesWithNames())
    }

    @Test
    fun `우승자_찾기_검증`() {
        // given
        val brokenCarUserNames = listOf(Name.of("mimi"), Name.of("jin"))
        val brokenCars = brokenCarUserNames.map { Car(moveStrategy = MoveStrategy { false }, name = it) }
        val cars = Cars(movableCars.plus(brokenCars))

        // when
        repeat(5) { cars.move() }

        // then
        assertThat(cars.getWinners()).containsAll(movableCarUserNames)
        assertThat(cars.getWinners()).doesNotContainAnyElementsOf(brokenCarUserNames)
    }
}
