package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.rule.RacingRuleImpl
import racingcar.util.RandomGenerator
import racingcar.util.RandomSetting

class RacingRuleTest {
    @Test
    fun `4 ~ 9 일 때 이동 가능한지 테스트`() {
        // 랜덤 값에 의존하기 때문에 정확한 검증이 어려워 일정 횟수만 테스트한다

        val randomSetting = object : RandomSetting {
            override val from: Int
                get() = 4
            override val until: Int
                get() = 10
        }
        val rule = RacingRuleImpl(RandomGenerator(randomSetting))

        repeat(100) {
            Assertions.assertThat(rule.canMove()).isEqualTo(true)
        }
    }

    @Test
    fun `0 ~ 3 일 때 이동이 불가능한지 테스트`() {
        // 랜덤 값에 의존하기 때문에 정확한 검증이 어려워 일정 횟수만 테스트한다

        val randomSetting = object : RandomSetting {
            override val from: Int
                get() = 0
            override val until: Int
                get() = 4
        }
        val rule = RacingRuleImpl(RandomGenerator(randomSetting))

        repeat(100) {
            Assertions.assertThat(rule.canMove()).isEqualTo(false)
        }
    }
}
