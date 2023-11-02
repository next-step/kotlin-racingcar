package study.racingcar.domain

/**
 * 0 ~ 9 중에서 랜덤 숫자가 4 이상인 경우, 이기는 룰
 * */
class FourOrMoreGameRule() : GameRule {
    override fun getResult(num: Int): Boolean {
        return num >= 4
    }
}
