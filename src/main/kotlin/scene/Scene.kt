package scene

interface Scene {

    fun hasNext(): Boolean
    fun before() {}
    fun update()
    fun after() {}
}
