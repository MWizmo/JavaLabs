package app.services;
import app.models.Types;
import app.repositories.TypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TypesService {

    @Autowired
    private TypesRepository repository;

    public List<Types> listAll() {
        return repository.findAll();
    }

    public void save(Types type) {
        repository.save(type);
    }

    public Types getById(Long id) {
        return repository.findById(id).get();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
