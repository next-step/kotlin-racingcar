package study.racingcar.domain

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class FourOrMoreGameRuleTest {

    // TODO-리뷰 요청  : 랜덤룰 테스트 로직
    // 예상 가능한 값이 나오도록 테스트 로직을 구상하려면, 로직에 추가 수정(random() 함수에 seed 값을 넣을 수 있도록) 필요한 상황
    // 테스트 로직을 위해 불필요한 로직을 수정하는 것이 좋은 방법일까 고민입니다.
    // 결국 내장 random 함수에 대한 테스트가 필요할까에 대한 결정이 필요한것 같습니다.
    @Test
    fun getResult() {
        val fourOrMoreGameRule = FourOrMoreGameRule()
        val result = fourOrMoreGameRule.getResult()
        assertTrue(result)
    }
}