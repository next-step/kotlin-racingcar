package types

interface Monoid<T> {
    fun empty(): Monoid<T>
    fun append(m1: T, m2: T): Monoid<T>
}
