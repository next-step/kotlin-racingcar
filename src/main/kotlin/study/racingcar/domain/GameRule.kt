package study.racingcar.domain

/**
 * getResult 의 구현에 따라, 랜덤 숫자를 기준으로 어떤 룰을 적용하느냐가 달라짐.
 * */
interface GameRule {
    fun getResult(): Boolean
}
