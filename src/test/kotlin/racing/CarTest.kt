package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun `전진 정상 케이스`(input: Int) {
        val car = Car(canMoveForward = canMoveForward, movingCondition = 0)
        for (i in 1..input) {
            car.moveForward()
        }
        assertThat(car.position).isEqualTo(input)
    }
}
