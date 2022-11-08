package step3.infra.impl

import step3.infra.RacingGameInputReader

class DefaultRacingGameInputReader : RacingGameInputReader {

    override fun readInput(): String = readln()
}
