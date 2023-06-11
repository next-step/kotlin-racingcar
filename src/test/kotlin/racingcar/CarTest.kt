package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.rule.RacingRuleImpl
import racingcar.util.RandomGenerator0To9

class CarTest {
    @Test
    fun `최초 생성 시 0에서 시작하는지 확인`() {
        val rule = RacingRuleImpl(RandomGenerator0To9())
        val car = Car(rule)
        Assertions.assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `이동할 수 있을 때 제대로 이동하는지 확인`() {
        val rule = AlwaysMoveRule()
        val car = Car(rule)
        val move = 5

        repeat(move) {
            car.move()
        }

        Assertions.assertThat(car.position).isEqualTo(move)
    }

    @Test
    fun `이동할 수 없을 때 이동하지 않는지 확인`() {
        val rule = NeverMoveRule()
        val car = Car(rule)
        val move = 10

        repeat(move) {
            car.move()
        }

        Assertions.assertThat(car.position).isEqualTo(0)
    }
}
