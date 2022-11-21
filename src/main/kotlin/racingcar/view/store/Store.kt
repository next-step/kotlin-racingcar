package racingcar.view.store

interface Store<T> {
    fun getState(): T
    fun setState(state: T)
}
