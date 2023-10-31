package types

interface Functor<out A> {
    fun <B> map(f: (A) -> B): Functor<B>
}
