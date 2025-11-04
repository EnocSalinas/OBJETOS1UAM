package com.tuempresa.facturacion.modelo;

import java.time.LocalDate;
import java.util.Collection;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
import lombok.*;

import com.tuempresa.facturacion.calculadores.CalculadorSiguienteNumeroParaAnyo;

@View(members= // Lección 4: UI más compacta
        "anyo, numero, fecha;" +   // misma línea
                "cliente;" +               // nueva línea
                "detalles;" +
                "observaciones"
)
@Entity @Getter @Setter
public class Factura {

    @Id
    @GeneratedValue(generator="system-uuid")
    @Hidden
    @GenericGenerator(name="system-uuid", strategy="uuid")
    @Column(length=32)
    String oid;

    @Column(length=4)
    @DefaultValueCalculator(CurrentYearCalculator.class)
    int anyo;

    @Column(length=6)
    @DefaultValueCalculator(
            value = CalculadorSiguienteNumeroParaAnyo.class,
            properties = @PropertyValue(name="anyo")
    )
    int numero;

    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class)
    LocalDate fecha;

    @TextArea
    String observaciones;

    @ManyToOne(fetch=FetchType.LAZY, optional=false)
    @ReferenceView("Simple") // Lección 4: usa la vista Simple de Cliente
    Cliente cliente;

    @ElementCollection
    @ListProperties("producto.numero, producto.descripcion, cantidad")
    Collection<Detalle> detalles;
}
