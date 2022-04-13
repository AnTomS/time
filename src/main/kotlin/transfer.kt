const val MASTERCARD = "MasterCard"
const val MAESTRO = "Maestro"
const val VISA = "Visa"
const val MIR = "МИР"
const val VKPAY = "VKPay"
var sumTransferMonth = 324_324
var sumTransferDay = 22234
var amount: Int = 50_000_00

fun main() {

    moneyTransfer()
    limitControl("VKPay", sumTransferMonth, sumTransferDay, amount)
}

fun choicePaymentSystem(): String {
    print(
        "Введите номер для выбора платёжной системы: \n" +
                "1. MasterCard \n" +
                "2. Maestro \n" +
                "3. Visa \n" +
                "4. Мир \n" +
                "5. VKPay \n"
    )
    val choice = when (readln().toInt()) {
        1 -> MASTERCARD
        2 -> MAESTRO
        3 -> VISA
        4 -> MIR
        else -> VKPAY
    }
    return choice
}

fun transferMastercardMaestro(): Int {
    return if (amount < 75_000_00) 0
    else (((amount * 0.006) + 2000) / 100).toInt()
}

fun transferVisaMir(): Int {
    return if ((amount * 0.0075).toInt() < 3500) 3500
    else ((amount * 0.0075) / 100).toInt()
}

fun moneyTransfer() {
    val amountKop = when (choicePaymentSystem()) {
        MASTERCARD -> transferMastercardMaestro()
        MAESTRO -> transferMastercardMaestro()
        VISA -> transferVisaMir()
        MIR -> transferVisaMir()
        else -> 0
    }
    return println("Комиссия за перевод $amountKop коп.")
}


fun limitControl(nameCard: String, sumTransferMonth: Int, sumTransferDay: Int, amount: Int) {
    if (nameCard == "VKPay" || nameCard == "Visa") {
        if (sumTransferMonth > 4_000_000 || amount > 1_500_000) {
            println("Превышен лимит переводов в VK Pay")

        } else {
            if (sumTransferDay > 1_500_000 || sumTransferMonth > 60_000_000) {
                println("Превышен лимит переводов")

            }

        }
    }
}


