package br.com.gerenciador.maq.db.entities.keys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkPlaceAllocationKey implements Serializable {
    public Long idWorkPlace;
    public Long idAllocation;
}
