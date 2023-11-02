package study.racingcar.domain

/**
 * 0 ~ 9 중에서 랜덤 숫자가 4 이상인 경우, 이기는 룰
 * */
class FourOrMoreGameRule(private var _num: Int = 0) : GameRule {

    private fun setRandomNum(num: Int) {
        _num = num
    }

    override fun setGameRule(num: Int) {
        setRandomNum(num)
    }

    override fun getResult(): Boolean {
        return _num >= 4
    }
}
