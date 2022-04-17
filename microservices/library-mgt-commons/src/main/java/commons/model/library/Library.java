package commons.model.library;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "library")
@Data
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer customerId;
    private Integer bookId;
    private LocalDate borrowFrom;
    private LocalDate borrowTill;

}
