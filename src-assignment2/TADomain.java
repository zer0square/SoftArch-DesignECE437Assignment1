import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Type Abstraction of domains of constants
 */
public class TADomain implements TAObject {
    private List<TAConstant> domain;

    public TADomain(TAConstant... args) {
        domain = new ArrayList<>();
        Collections.addAll(domain, args);
    }

    protected List<TAConstant> getList(){

        return domain;
    }

    public boolean add(TAConstant constant) {
        return domain.add(constant);
    }

    public void list() {
        for (TAConstant cte : domain) cte.list();
    }
}
