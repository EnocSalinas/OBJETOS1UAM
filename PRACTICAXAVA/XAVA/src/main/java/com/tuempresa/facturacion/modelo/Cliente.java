package com.tuempresa.facturacion.modelo;

import javax.persistence.*;
import org.openxava.annotations.*;
import lombok.*;

@Entity
@View(name="Simple", members="numero, nombre") // Lección 4: vista compacta
@Getter @Setter
public class Cliente {

    @Id
    @Column(length = 6)
    int numero;

    @Column(length = 50)
    @Required
    String nombre;

    // (Lección 2) Dirección embebida; puedes quitar @NoFrame si prefieres con marco
    @Embedded @NoFrame
    Direccion direccion;
}
