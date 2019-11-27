package app.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Goods {

    private Long id;
    private String title;
    private float weight;
    private int type;


    public Goods(){

    }

    public Goods(Long id, String title, float weight, int type) {
        this.id = id;
        this.title = title;
        this.weight = weight;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight){
        this.weight = weight;
    }

    public int getType() {
        return type;
    }

    public void setType(int type){
        this.type = type;
    }
}
