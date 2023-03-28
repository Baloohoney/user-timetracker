fun main() {
    val timeAgo = 100000
    println(agoToText(timeAgo))

}
fun hourNotation (timeAgo: Int) : String {
    return when {
        timeAgo in 3_600..7199 || timeAgo in 75_600..79199 -> " час "
        timeAgo in 7_200..17999 || timeAgo in 79_200..86399 -> " часа "
        else -> " часов "
    }
}

fun minuteNotation (timeAgo: Int) : String {
    return when {
        timeAgo in 60..119 || timeAgo in 1260..1319
                || timeAgo in 1860..1919 || timeAgo in 2460..2519
                || timeAgo in 3060..3119 -> " минуту "

        timeAgo in 120..299 || timeAgo in 1320..1499
                || timeAgo in 1920..2099 || timeAgo in 2520..2699
                || timeAgo in 3120..3299 -> " минуты "

        else -> " минут "
        }
}


fun agoToText (timeAgo: Int): String {
    return when {
        timeAgo > 60 && timeAgo / 60 < 60 -> {
            "был (а) " + timeAgo / 60 + minuteNotation(timeAgo) + "назад"
        }
        timeAgo >= 3600 && timeAgo <= 3_600 * 24 -> {
            "был (а) " + timeAgo / 3_600 + hourNotation(timeAgo) + "назад"
        }
        timeAgo > 3_600 * 24 && timeAgo <= 3_600 * 48 -> {
            "был (а) вчера"
        }
        timeAgo > 3_600 * 48 && timeAgo <= 3_600 * 72 -> {
            "был (а) позовчера"
        }
        timeAgo > 3_600 * 72 -> {
            "был (а) давно"
        }
        else -> {"был (а) только что"}
    }
}
