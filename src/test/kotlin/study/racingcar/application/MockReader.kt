package study.racingcar.application

class MockReader(private val inputCarNames: String, private val inputNumber: String) : Reader {
    override fun readString(): String? {
        return inputCarNames
    }

    override fun readInt(): String? {
        return inputNumber
    }
}
