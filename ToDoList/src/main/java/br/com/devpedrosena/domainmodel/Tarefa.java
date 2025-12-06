package br.com.devpedrosena.domainmodel;

import jakarta.persistence.*;

@Entity
@Table(name = "Tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREFA")
    private Long id;

}
