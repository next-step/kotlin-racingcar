package study.racingcar.domain

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

class FourOrMoreGameRuleTest {

    @Test
    @DisplayName("FourOrMoreGameRule 객체를 선언하고 / getResult() 실행시 / 예외 없이 정상 동작하는지 확인")
    fun getResult() {
        // given
        val fourOrMoreGameRule = FourOrMoreGameRule()

        // when
        val result = fourOrMoreGameRule.getResult()

        // then
        assertTrue(result)
    }
}