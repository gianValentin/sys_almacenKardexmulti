/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 *
 * @author gian
 */
@Embeddable
public class Detalle_Entrada_ID implements Serializable {
    
    @ManyToOne
    private kardexVo kardexVo;
    
    @ManyToOne
    private EntradaVo entradaVo;

    public Detalle_Entrada_ID() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.kardexVo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Detalle_Entrada_ID other = (Detalle_Entrada_ID) obj;
        if (!Objects.equals(this.kardexVo, other.kardexVo)) {
            return false;
        }
        return true;
    }

    public kardexVo getKardexVo() {
        return kardexVo;
    }

    public void setKardexVo(kardexVo kardexVo) {
        this.kardexVo = kardexVo;
    }

    public EntradaVo getEntradaVo() {
        return entradaVo;
    }

    public void setEntradaVo(EntradaVo entradaVo) {
        this.entradaVo = entradaVo;
    }
    
       
}
