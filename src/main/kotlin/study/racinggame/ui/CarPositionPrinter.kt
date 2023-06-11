package study.racinggame.ui

interface CarPositionPrinter {
    fun print(position: Int)
}

object HyphenCarPositionPrinter : CarPositionPrinter {
    override fun print(position: Int) {
        println("-".repeat(position))
    }
}
