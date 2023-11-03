package study.racingcar.application

class MockReader(private val inputString: String, private val inputInt: String) : Reader {
    override fun readString(): String? {
        return inputString
    }

    override fun readInt(): String? {
        return inputInt
    }
}
