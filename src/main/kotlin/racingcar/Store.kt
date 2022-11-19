package racingcar

interface Store<T> {
    fun findAll(): List<T>
    fun saveAll(list: List<T>): List<T>
}
