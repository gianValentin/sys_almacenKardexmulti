
package pe.senati.service;

import pe.senati.model.EntradaVo;


public interface EntradaService {
    public abstract void Insert(EntradaVo entradaVo);
    
    public abstract EntradaVo findNewInsert();
}
