package racingcar.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.move.RandomMoveStrategy

class RandomGeneratorTest {

    @Test
    fun `자동차 이동 조건 숫자는 0부터 9사이 랜덤값 생성`() {
        assertThat(
            RandomGenerator.generateRandomNum(
                RandomMoveStrategy.RANDOM_MINIMUM,
                RandomMoveStrategy.RANDOM_MAXIMUM
            )
        )
            .isBetween(RandomMoveStrategy.RANDOM_MINIMUM, RandomMoveStrategy.RANDOM_MAXIMUM)
    }
}
