package types

interface Monad<out A> : Functor<A> {
    fun <V> pure(value: V): Monad<V>
    infix fun <B> flatMap(f: (A) -> Monad<B>): Monad<B>
    infix fun <B> leadTo(m: Monad<B>): Monad<B> = flatMap { m }
    override fun <B> map(f: (A) -> B): Functor<B> = flatMap { a -> pure(f(a)) }
}
