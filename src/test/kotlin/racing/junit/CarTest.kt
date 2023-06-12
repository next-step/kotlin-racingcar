package racing.junit

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.condition.FirstRoundCondition
import racing.model.Car

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = [1])
    fun `doRacing 성공`(round: Int) {
        val conditions = listOf(FirstRoundCondition())
        val car = Car(0)

        car.doRacing(round, conditions)

        Assertions.assertThat(car.dist).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [2])
    fun `doRacing 실패`(round: Int) {
        val conditions = listOf(FirstRoundCondition())
        val car = Car(1)

        car.doRacing(round, conditions)

        Assertions.assertThat(car.dist).isEqualTo(1)
    }
}
