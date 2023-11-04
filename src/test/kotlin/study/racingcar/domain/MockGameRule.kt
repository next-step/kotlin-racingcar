package study.racingcar.domain

class MockGameRule
class WinGameRule : GameRule {
    override fun getResult(): Boolean {
        return true
    }

}

class LoseGameRule : GameRule {
    override fun getResult(): Boolean {
        return false
    }
}
