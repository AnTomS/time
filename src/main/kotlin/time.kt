package ru.netology


fun main() {
    print("Введите время, как давно пользователь был онлайн, в секундах: ")
    val timeInSite: Int = readln().toInt()

    val secondsToMinutes: Int = timeInSite / 60
    val minutesToHours: Int = secondsToMinutes / 60

    print("Введите имя пользователя: ")
    val name: String = readln()


    fun timeWithOne(): Boolean =
        (secondsToMinutes == 1 || secondsToMinutes % 10 == 1 && secondsToMinutes % 100 != 11) ||
                (minutesToHours == 1 || minutesToHours % 10 == 1 && minutesToHours % 100 != 11)

    fun timeWithTwoThreeFour(): Boolean = (secondsToMinutes < 5 && secondsToMinutes != 0 ||
            secondsToMinutes % 10 == 2 && secondsToMinutes != 12 ||
            secondsToMinutes % 10 == 3 && secondsToMinutes != 13 ||
            secondsToMinutes % 10 == 4 && secondsToMinutes != 14) ||
            (minutesToHours < 5 && minutesToHours != 0 ||
                    minutesToHours % 10 == 2 && minutesToHours != 12 ||
                    minutesToHours % 10 == 3 && minutesToHours != 13 ||
                    minutesToHours % 10 == 4 && minutesToHours != 14)

    fun timeToMinute(): String =
        if (timeWithOne()) "$secondsToMinutes минуту назад"
        else if (timeWithTwoThreeFour()) "$secondsToMinutes минуты назад"
        else "$secondsToMinutes минут назад"

    fun timeToHour(): String =
        if (timeWithOne()) "$minutesToHours час назад"
        else if (timeWithTwoThreeFour()) "$minutesToHours часа назад"
        else "$minutesToHours часов назад"


    fun agoToText() {
        val allTime = when (timeInSite) {
            in 0..60 -> "$name в сети только что"
            in 61..3_600 -> "$name в сети ${timeToMinute()}"
            in 3_601..86_400 -> "$name в сети ${timeToHour()}"
            in 86_401..172_800 -> "$name в сети сегодня"
            in 172_801..259_200 -> "$name в сети вчера"
            else -> "$name в сети давно"
        }
        println(allTime)
    }


    return agoToText()
}