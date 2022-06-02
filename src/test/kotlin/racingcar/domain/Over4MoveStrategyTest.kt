package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.service.RandomGenerator

class Only5RandomGenerator : RandomGenerator {
    override fun generate(): Int {
        return 5
    }
}

class Only4RandomGenerator : RandomGenerator {
    override fun generate(): Int {
        return 4
    }
}

class Over4MoveStrategyTest {

    @Test
    fun `4 이하값에 대해선 car를 이동시키지 않는다`() {
        val moveStrategy = Over4MoveStrategy(Only4RandomGenerator())
        val car = Car(1)

        moveStrategy.move(car)

        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `5 이상값에 대해선 car를 이동시킨다`() {
        val moveStrategy = Over4MoveStrategy(Only5RandomGenerator())
        val car = Car(1)

        moveStrategy.move(car)

        assertThat(car.position).isEqualTo(1)
    }
}
