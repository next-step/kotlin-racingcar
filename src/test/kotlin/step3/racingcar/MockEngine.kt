package step3.racingcar

class SuccessEngine : Engine {
    override fun move(): Boolean {
        return true
    }
}

class FailEngine : Engine {
    override fun move(): Boolean {
        return false
    }
}
