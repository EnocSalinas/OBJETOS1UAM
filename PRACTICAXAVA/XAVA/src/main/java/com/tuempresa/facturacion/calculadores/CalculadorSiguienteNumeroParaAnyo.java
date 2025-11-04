package com.tuempresa.facturacion.calculadores;

import javax.persistence.Query;
import org.openxava.calculators.ICalculator;
import org.openxava.jpa.XPersistence;
import lombok.Getter; import lombok.Setter;

public class CalculadorSiguienteNumeroParaAnyo implements ICalculator {

    @Getter @Setter
    int anyo;

    @Override
    public Object calculate() throws Exception {
        Query q = XPersistence.getManager()
                .createQuery("select max(f.numero) from Factura f where f.anyo = :anyo");
        q.setParameter("anyo", anyo);
        Integer ultimo = (Integer) q.getSingleResult();
        return ultimo == null ? 1 : ultimo + 1;
    }
}
