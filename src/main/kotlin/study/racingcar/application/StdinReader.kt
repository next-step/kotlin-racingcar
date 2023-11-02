package study.racingcar.application

class StdinReader : Reader {
    override fun read(): String? {
        return readlnOrNull()
    }
}
