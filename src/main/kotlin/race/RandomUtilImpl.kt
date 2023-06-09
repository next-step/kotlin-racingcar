package race

object RandomUtilImpl : RandomUtil {
    override fun generateRandomSingleDigit(): Int = (0..9).random()
}
