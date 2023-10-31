package study.racing.rule

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RuleTest {
    @Test
    fun `항상 움직이는 규칙이 등록되고, 움직임 판단 여부를 요청했을 때, 결과는 항상 참이다`() {
        // given: 항상 움직이는 규칙이 등록되한다
        val rule = TestRuleMove()

        // when: 움직임 판단 여부를 요청한다.
        val actual = rule.isMove()

        // then: 결과는 참이다.
        assertThat(actual).isTrue()
    }
}
