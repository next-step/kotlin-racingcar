package study.racingcar.application

class StdinReader : Reader {
    override fun readString(): String? {
        return readlnOrNull()
    }

    override fun readInt(): String? {
        return readlnOrNull()
    }
}
