package br.com.gerenciador.maq.db.entities;

import br.com.gerenciador.maq.db.entities.keys.WorkPlaceAllocationKey;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Calendar;

@Table(name = "TB_ALOCACAO")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AllocationEntity extends PanacheEntityBase {

    @EmbeddedId
    public WorkPlaceAllocationKey id;

    @Column(name = "DT_INICIO")
    @CreationTimestamp
    public LocalDateTime startDate;

    @Column(name = "DT_FIM")
    @Temporal(TemporalType.TIMESTAMP)
    public Calendar endDate;

}
