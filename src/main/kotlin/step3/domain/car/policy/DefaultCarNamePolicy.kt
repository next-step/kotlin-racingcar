package step3.domain.car.policy

object DefaultCarNamePolicy : CarNamePolicy {
    override fun isValidName(name: String): Boolean = name.length in (1..5)
}
