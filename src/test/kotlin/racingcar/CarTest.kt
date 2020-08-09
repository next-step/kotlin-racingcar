package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.strategy.MovingStrategy
import racingcar.strategy.RandomStrategy

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = [1000, 113, 989, 119, 0])
    fun `Car forward test`(repetition: Int) {
        val car = Car(mutableListOf(0), RandomStrategy())
        repeat(repetition) {
            car.forward()
        }
        repeat(repetition) {
            Assertions.assertThat(car.position[it]).isEqualTo(it)
        }
        Assertions.assertThat(car.position.size).isEqualTo(repetition + 1)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 999, 10, 2020, 0])
    fun `Car wait test`(repetition: Int) {
        val car = Car(mutableListOf(0), RandomStrategy())
        repeat(repetition) {
            car.wait()
        }
        repeat(repetition) {
            Assertions.assertThat(car.position[it]).isEqualTo(0)
        }
        Assertions.assertThat(car.position.size).isEqualTo(repetition + 1)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 999, 10, 2020, 1919, 99999])
    fun `Car run test`(repetition: Int) {
        val car = Car(mutableListOf(0), MovingStrategy())
        repeat(repetition) {
            car.run()
        }
        repeat(repetition) {
            Assertions.assertThat(car.position[it]).isEqualTo(it)
        }
        Assertions.assertThat(car.position.size).isEqualTo(repetition + 1)
    }
}
