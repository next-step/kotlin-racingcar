package scene

abstract class Scene {

    companion object {
        var player = 0
            private set
        var round = 0
            private set
    }

    fun fire() {
        before()
        update()
        after()
    }

    abstract fun hasNext(): Boolean
    protected abstract fun before()
    protected abstract fun update()
    protected abstract fun after()

    protected fun setPlayer(value: Int) {
        player = value
    }

    protected fun setStage(value: Int) {
        round = value
    }
}
