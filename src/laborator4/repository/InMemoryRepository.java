package laborator4.repository;





import java.util.List;
import java.util.ArrayList;

public abstract class InMemoryRepository<T> implements ICrudRepository<T> {

    protected List<T> repoList;

    public InMemoryRepository(){
        this.repoList = new ArrayList<>();
    }

    @Override
    public T create(T obj){
        if(!repoList.contains(obj)) {
            this.repoList.add(obj);
            return null;
        }
        return obj;
    }

    @Override
    public List<T> getAll(){
        return this.repoList;
    }

    @Override
    public void delete(T obj){
        this.repoList.remove(obj);
    }
}
