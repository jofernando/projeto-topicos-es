package br.edu.ufape.editais.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantidade;

    public <T> T method(Class<T> type) {
        return null;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}