package racingcar.view.store

typealias Listener = () -> Unit
typealias UnSubscribe = () -> Unit

open class Store<T>(initialState: T) {
    private var state = initialState
    private val listeners = HashSet<Listener>()

    fun getState(): T {
        return this.state
    }
    fun setState(state: T) {
        this.state = state
        this.listeners.forEach { listener -> listener() }
    }
    fun subscribe(listener: Listener): UnSubscribe {
        listeners.add(listener)
        return { listeners.remove(listener) }
    }
}
