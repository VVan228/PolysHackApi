package hack.polyus.goldenrush.models.transport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransportParam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long typeId;
    String name;
    boolean isEnum;


}