package hibernate;

import tables.*;

import java.util.List;
import java.util.Optional;

/**
 * Interfejs zbierający metody CRUD wykonywane na Produktach i ich dzieciach
 */
public interface ProductsRepository {

    /**
     * Tworzy produkt. Dla klas dzieci pobiera już istniejące z bazy,
     * lub dodaje raze z produktem.
     *
     * @param product produkt do dodania
     */
    void createProduct(Product product);

    /**
     * Usuwa produkt z danym id.
     * W przypadku braku produktu wypisuje w logu informację.
     *
     * @param id id szukanego produktu
     */
    void deleteProductById(Integer id);

    /**
     * Zwraca obiekt produktu o danym id. W przypadku, gdy nie ma produktu, zwraca null.
     *
     * @param id id szukanego produktu
     * @return Product w optionalu -> obsłużyć null
     */
    Optional<Product> getProductById(Integer id);

    /**
     * Zwraca listę produktów o podanym tytule.
     * W przypadku braku produktów zwraca pustą listę.
     *
     * @param title Tytuł szukanego produktu
     * @return Lista produktów o podanym tytule. W Przypadku braku produktów lista będzie pusta.
     */
    List<Product> getListOfProductWithGivenTitle(String title);

    /**
     * Metoda do wyciągnięcia wszystkich produktów z bazy.
     *
     * @return zwraca listę wszystkich produktów. Pustą listę, gdy nie ma produktów.
     */
    List<Product> getAllProducts();

    /**
     * Zmiana kategorii w produkcie o danym id.
     * W przypadku braku produktu o wskazanym id zwraca pusty optional i warning.
     * W przypadku braku kategorii w bazie dodaje kategorię.
     *
     * @param id       id produktu
     * @param category kategoria, którą chcesz zmienić
     * @return Produkt ze zmienioną kategorią lub pusty optional, gdy produkt o danym id nie istnieje.
     */
    Optional<Product> changeProductCategory(Integer id, Category category);

    /**
     * Zmiana oddziału w produkcie o danym id.
     * W przypadku braku produktu o wskazanym id zwraca pusty optional i warning.
     * W przypadku braku oddziału w bazie dodaje oddział.
     *
     * @param id     produktu
     * @param branch nowy oddział
     * @return Produkt ze zmienionym oddziałem lub pusty optional, gdy produkt o danym id nie istnieje.
     */
    Optional<Product> changeProductBranch(Integer id, Branch branch);


    /**
     * Dodaje nowy nośnik. W przypadku, gdy istnieje już nośnik o danej nazwie, zwraca nośnik z bazy.
     *
     * @param carrier nośnik do dodania
     * @return zwraca dodany nośnik lub już istniejący nośnik z danymi parametrami.
     */
    Carrier addCarrier(Carrier carrier);

    /**
     * Usuwa nośnik z bazy.
     *
     * @param carrier nośnik do usunięcia.
     * @return true - usunięty; false - brak nośnika w bazie;
     */
    boolean removeCarrier(Carrier carrier);

    Optional<Carrier> getCarrier(Carrier carrier);

    /**
     * Dodaje nową kategorię PEGI. W przypadku, gdy istnieje już kategoria PEGI o danym tytule, zwraca kategorię PEGI z bazy.
     *
     * @param pegiCategory kategoria PEGI do dodania
     * @return zwraca dodaną kategorię PEGI lub już istniejącą kategorię PEGI z danymi parametrami.
     */
    PegiCategory addPegiCategory(PegiCategory pegiCategory);


    /**
     * Usuwa kategorię PEGI z bazy.
     *
     * @param pegiCategory kategoria PEGI do usunięcia.
     * @return true — usunięta; false — brak kategorii PEGI w bazie;
     */
    boolean removePegiCategory(PegiCategory pegiCategory);

    Optional<PegiCategory> getPegiCategory(PegiCategory pegiCategory);

    /**
     * Dodaje nową kategorię. W przypadku, gdy istnieje już kategoria o danym tytule, zwraca kategorię z bazy.
     *
     * @param category kategoria do dodania
     * @return zwraca dodaną kategorię lub już istniejącą kategorię z danymi parametrami.
     */
    Category addCategory(Category category);


    /**
     * Usuwa kategorię z bazy.
     *
     * @param category kategoria  do usunięcia.
     * @return true — usunięta; false — brak kategorii w bazie;
     */
    boolean removeCategory(Category category);

    Optional<Category> getCategory(Category category);

    /**
     * Dodaje nowego reżyser. W przypadku, gdy istnieje już reżyser o danej nazwie, zwraca reżysera z bazy.
     *
     * @param director reżyser do dodania
     * @return zwraca dodanego reżyser lub już istniejącego reżysera z danymi parametrami.
     */
    Director addDirector(Director director);

    /**
     * Usuwa reżysera z bazy.
     *
     * @param director reżyser do usunięcia.
     * @return true - usunięty; false - brak reżysera w bazie;
     */
    boolean removeDirector(Director director);

    Optional<Director> getDirector(Director director);

    /**
     * Dodaje nowy oddział. W przypadku, gdy istnieje już oddział o danym adresie pocztowym zwraca oddział z bazy.
     *
     * @param branch oddział do dodania
     * @return zwraca dodany oddział lub już istniejący oddział z danymi parametrami.
     */
    Branch addBranch(Branch branch);

    /**
     * Usuwa oddział z bazy.
     *
     * @param branch oddział do usunięcia.
     * @return true - usunięty; false - brak oddziału w bazie;
     */
    boolean removeBranch(Branch branch);

    Optional<Branch> getBranch(Branch branch);


}
