package br.edu.ufape.vinculos.business.models.enums;

public enum TipoVinculoEnum {
    PIBIX("Pibix"),
    PIBIT("Pibit");

    private final String tipoVinculo;

    TipoVinculoEnum(String tipoVinculo) {
        this.tipoVinculo = tipoVinculo;
    }

    public String getTipoVinculo() {
        return tipoVinculo;
    }


}
