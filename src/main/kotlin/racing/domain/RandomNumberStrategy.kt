package racing.domain

object RandomNumberStrategy : NumberStrategy {
    override fun getNumber(): Int = (0..9).random()
}
