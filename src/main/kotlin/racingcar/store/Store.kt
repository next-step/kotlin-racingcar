package racingcar.store

interface Store<T> {
    fun getState(): T
    fun setState(state: T): T
}
