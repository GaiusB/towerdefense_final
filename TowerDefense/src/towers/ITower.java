package towers;

public interface ITower {

    void upgradeDamage(); // Améliore les dégâts de la tour

    void upgradeRange(); // Obtient le niveau actuel de la tour.
    // @return Le niveau de la tour.

    int getLevel(); // Obtient le nombre maximal de cibles que la tour peut prendre en même temps.
    // @return Le nombre maximal de cibles.

    int getTargetNumber(); // nombre de cible que la tour peut prendre
    // Définit les dégâts de la tour.
    // @param damage   Les nouveaux dégâts de la tour.

    void setDamage(int damage); // Définit la portée de la tour.
    // @param range    La nouvelle portée de la tour.

    void setRange(int range); //Obtient la portée actuelle de la tour.
    //  @return La portée de la tour.

    int getRange();

}