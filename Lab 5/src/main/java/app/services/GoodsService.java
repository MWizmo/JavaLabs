package app.services;
import app.models.Goods;
import app.repositories.GoodsRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private GoodsRepository repository;

    public List<Goods> listAll() {
        return repository.findAll();
    }

    public void edit(Goods product) {
        repository.deleteById(product.getId());
        repository.save(product);
    }

    public void save(Goods product) {
        repository.save(product);
    }

    public Goods getById(Long id) {
        return repository.findById(id).get();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
