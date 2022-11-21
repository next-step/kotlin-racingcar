package racingcar.view.store

typealias Listener = () -> Unit
typealias UnSubscribe = () -> Unit

abstract class Store<T> {
    protected val listeners = HashSet<Listener>()

    abstract fun getState(): T
    abstract fun setState(state: T)
    abstract fun subscribe(listener: Listener): UnSubscribe
}
