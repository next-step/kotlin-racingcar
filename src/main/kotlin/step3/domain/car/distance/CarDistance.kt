package step3.domain.car.distance

interface CarDistance<T> where T : Number, T : Comparable<T> {

    val distance: T

    fun increment(addDistance: T)
}
