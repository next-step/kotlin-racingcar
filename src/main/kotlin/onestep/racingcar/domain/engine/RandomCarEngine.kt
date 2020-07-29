package onestep.racingcar.domain.engine

object RandomCarEngine : CarEngine {
    private const val GO_LIMIT = 4

    override fun run() = if (isMove()) 1 else 0

    private fun isMove() = (0..9).random() > GO_LIMIT
}
