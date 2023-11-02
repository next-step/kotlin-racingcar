package study.racingcar.domain

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class FourOrMoreGameRuleTest {

    @ValueSource(ints = [0, 1, 2, 3])
    @ParameterizedTest
    fun `무작위 값이 3이하일 경우 false 를 반환한다`(num: Int) {
        // given
        val fourOrMoreGameRule = FourOrMoreGameRule(num)

        // when
        val result = fourOrMoreGameRule.getResult()

        // then
        assert(!result)
    }

    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `FourOrMoreGameRule 객체를 선언하고 getResult() 실행시 예외 없이 정상 동작한다`(num: Int) {
        // given
        val fourOrMoreGameRule = FourOrMoreGameRule(num)

        // when
        val result = fourOrMoreGameRule.getResult()
    }
}
