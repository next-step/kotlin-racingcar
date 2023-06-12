package racing.junit

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.condition.FirstRoundCondition

class RacingConditionTest {
    @ParameterizedTest
    @ValueSource(ints = [1])
    fun `첫번째 라운드 condition 성공`(round: Int) {
        val condition = FirstRoundCondition()

        Assertions.assertThat(condition.predicate(round)).isEqualTo(true)
    }

    @ParameterizedTest
    @ValueSource(ints = [2])
    fun `첫번째 라운드 condition 실패`(round: Int) {
        val condition = FirstRoundCondition()

        Assertions.assertThat(condition.predicate(round)).isEqualTo(false)
    }
}
