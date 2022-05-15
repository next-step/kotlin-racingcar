package racing.scene

interface Scene {
    fun start() {}
    fun update()
    fun hasNext(): Boolean
    fun onDestroy() {}
}
