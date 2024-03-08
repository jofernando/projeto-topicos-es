package br.edu.ufape.vinculos.business.models;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.hibernate.proxy.HibernateProxy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Projeto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private List<String> palavrasChave;

    private Date dataCriacao;

    private Date dataCertificacao;

    private String linguagemDeDesenvolvimento;

    private String campoDeAplicacao;

    private String tipoDeSistema;

     @Override
    public final boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy
                ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass()
                : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass()
                : this.getClass();
        if (thisEffectiveClass != oEffectiveClass)
            return false;
        Vinculo vinculo = (Vinculo) o;
        return getId() != null && Objects.equals(getId(), vinculo.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode()
                : getClass().hashCode();
    }



}
