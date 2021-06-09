import kotlin.math.sqrt

/*
1) Réaliser un programme qui permet à l'utilisateur d'encoder
   un nombre entier pour tester si c'est un nombre premier.

   Rappel : Un nombre premier est division uniquement par 1 et lui même.
 */

fun main() {

    print("Veuillez entrer un nombre entier : ")
    val number: Int = readLine()!!.toInt()

    var isPrime: Boolean = false

    if (number == 2) {
        isPrime = true
    }
    else if (number > 2 && number % 2 != 0) {
        isPrime = true
        val divMax = sqrt(number.toDouble()).toInt()

        //region Solution base sur l'utilisation d'un range
//        // -> Pour 13, on test  3->12 (3 5 7 9 11)
//        val divisions = 3 until divMax step 2
//        for(div: Int in divisions) {
//            if(number % div == 0) {
//                isPrime = false
//                break
//            }
//        }
        //endregion

        //region Alternative avec la boucle while
        var count = 3
        while (isPrime && count < divMax) {
            if(number % count == 0) {
                isPrime = false
            }
            count += 2
        }
        //endregion
    }

    if(isPrime) {
        println("Le nombre $number est un nombre premier")
    }
    else {
        println("Le nombre $number n'est pas premier")
    }
}