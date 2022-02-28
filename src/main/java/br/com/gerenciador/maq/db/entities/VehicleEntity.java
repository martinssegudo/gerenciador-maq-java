package br.com.gerenciador.maq.db.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Table(name = "TB_VEICULO")
@Entity
@GenericGenerator(
        name = "SEQ_VEICULO",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name = "sequence_name", value = "SEQ_VEICULO"),
                @Parameter(name = "initial_value", value = "1"),
                @Parameter(name = "increment_size", value = "1")
        }
)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleEntity extends PanacheEntityBase {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VEICULO")
        @Column(name = "ID_VEICULO", nullable = false)
        public Long id;

        @Column(name = "DS_IDENTIFICATION", nullable = false)
        public String identification;

        @Column(name = "DS_MODELO", nullable = false)
        public String model;

        @Column(name = "DS_ANO", nullable = false, length = 4)
        public String year;

        @Column(name = "DS_FABRICANTE")
        public String fabricator;

        @Column(name = "DT_INICIO")
        @CreationTimestamp
        public Calendar startDate;

        @Column(name = "DT_FIM")
        @Temporal(TemporalType.TIMESTAMP)
        public Calendar endDate;


        public static Optional<VehicleEntity>  findByIdentification(String identification){
                Map<String, Object> params = new HashMap<>();
                params.put("ident", identification);

                return VehicleEntity
                        .find("identification = :ident", params)
                        .singleResultOptional();
        }
}
