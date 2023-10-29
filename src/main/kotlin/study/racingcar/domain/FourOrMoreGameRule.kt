package study.racingcar.domain

/**
 * 0 ~ 9 중에서 랜덤 숫자가 4 이상인 경우, 이기는 룰
 * */
class FourOrMoreGameRule : GameRule {
    private fun getRandomNumber(): Int {
        return (0..9).random()
    }

    override fun getResult(): Boolean {
        return getRandomNumber() >= 4
    }
}
