package carracing

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarsTest {
    val initialPosition = 0
    val minConditionToMove = 4

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `car should move when power is greater or equal to 4`(power: Int) {
        // given
        val cars =
            Cars.create(
                listOf(
                    Car(initialPosition, minConditionToMove),
                    Car(2, minConditionToMove),
                    Car(4, minConditionToMove),
                ),
            )
        val numberGenerator = FixedNumberGenerator(fixedValue = power)
        // when
        cars.moveAllCars(numberGenerator)
        // then
        assertThat(cars.getCarPositions()).containsExactly(1, 3, 5)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `car should move when power is less than 4`(power: Int) {
        // given
        val cars =
            Cars.create(
                listOf(
                    Car(initialPosition, minConditionToMove),
                    Car(2, minConditionToMove),
                    Car(4, minConditionToMove),
                ),
            )
        val numberGenerator = FixedNumberGenerator(fixedValue = power)
        // when
        cars.moveAllCars(numberGenerator)
        // then
        assertThat(cars.getCarPositions()).containsExactly(0, 2, 4)
    }

    @Test
    fun `cars can be initialize with initialPosition minConditionToMove`() {
        // given, when
        val totalCar = 5
        val cars = Cars.create(totalCar, 0, 3)
        // then
        assertThat(cars.getCarPositions()).containsExactly(0, 0, 0, 0, 0)
        assertThat(cars.getCarPositions().size).isEqualTo(totalCar)
    }
}

class FixedNumberGenerator(val fixedValue: Int) : NumberGenerator {
    override fun generate(): Int {
        return fixedValue
    }
}
