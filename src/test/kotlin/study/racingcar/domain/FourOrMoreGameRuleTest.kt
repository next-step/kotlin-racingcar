package study.racingcar.domain

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

class FourOrMoreGameRuleTest {

    @Test
    @DisplayName("FourOrMoreGameRule 의 getResult() 가 예외 없이 정상 동작하는지 확인")
    fun getResult() {
        val fourOrMoreGameRule = FourOrMoreGameRule()
        val result = fourOrMoreGameRule.getResult()
        assertTrue(result)
    }
}