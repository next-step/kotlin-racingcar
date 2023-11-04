package study.racingcar.domain

/**
 * 0 ~ 9 중에서 랜덤 숫자가 4 이상인 경우, 이기는 룰
 * */
class FourOrMoreGameRule : GameRule {
    override fun getResult(): Boolean {
        return getRandomNumber() >= WINNING_NUMBER
    }

    private fun getRandomNumber(): Int {
        return (MIN_NUMBER..MAX_NUMBER).random()
    }

    companion object {
        const val MIN_NUMBER = 0
        const val MAX_NUMBER = 9
        const val WINNING_NUMBER = 4
    }
}
