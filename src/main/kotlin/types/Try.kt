package types

sealed class Try<out R> : Monad<R> {

    companion object {
        fun <V> pure(value: V) = Success(0).pure(value)
    }
    override fun <B> map(f: (R) -> B): Try<B> {
        return super.map(f) as Try<B>
    }

    override fun <V> pure(value: V): Try<V> {
        return Success(value)
    }

    override fun <B> flatMap(f: (R) -> Monad<B>): Try<B> {
        return when (this) {
            is Failure -> Failure(e)
            is Success -> try { f(value) as Try<B> } catch (e: Throwable) { Failure(e) }
        }
    }

    fun getOrThrow(): R {
        return when (this) {
            is Failure -> throw e
            is Success -> value
        }
    }
}

data class Failure(val e: Throwable) : Try<Nothing>()

data class Success<B>(val value: B) : Try<B>()

infix fun <T, R> Try<(T) -> R>.apply(f: Try<T>) = when (this) {
    is Failure -> Failure(e)
    is Success -> f.map(value)
}
