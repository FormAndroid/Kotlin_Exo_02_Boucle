/*
2) Réaliser une programme pour jouer au "Juste au prix"
   La valeur à trouver est généré aléatoirement entre 0 et 1000

   L'utilisateur peut choisir sa difficulté :
     - Facile    : Pas de limite
     - Normal    : 30 tentatives
     - Difficile : 10 tentatives

   Afficher un message en fin de programme qui :
     - S'il a gagné, affiche son score
     - S'il a perdu, la valeur mystère
 */

fun main() {
    // Générer la valeur mystere
    val nbMystere: Int = (1..100).random()

    // Saisie de l'utilisateur (difficulté)
    print("""
        Veuillez selectionner la difficulté :
            1) Facile    (Pas de limite)
            2) Normal    (30 tentatives) [Default]
            3) Difficile (10 tentatives)
        > 
    """.trimIndent())

    // Défini de la limite de tentative

    // - Mini démo de l'utilisation d'un tuple avec du destructuring
    val (infinteTentative, maxTentative) = when (readLine()) {
        "3"  -> Pair(false, 10)
        "1"  -> Pair(true, 0)
        else -> Pair(false, 30)
    }

    // Initialiser une variable pour les tentatives
    var nbTentative: Int = 0


    // Boucle
    var win: Boolean = false
    do {
        nbTentative++

        // Saisie utilisateur d'un nombre
        print("Entrer une valeur : ")
        val nbUser = readLine()!!.toInt()

        // Teste de la valeur
        when {
            (nbUser < nbMystere) -> println("Plus grand")
            (nbUser > nbMystere) -> println("Plus petit")
            else -> win = true
        }

    } while (!win && (infinteTentative || nbTentative < maxTentative))
    println()

    // Affichage du score
    if(win) {
        println("Bravo ! Vous avez trouvé en $nbTentative tentatives !")
    }
    else {
        println("Perdu. Le nombre etait $nbMystere")
    }
}