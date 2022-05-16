package step4.racingcar.racingcar

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
