package br.com.dio.model;

public enum GameStatusEnum {
    NON_STARTED("Não iniciado"),
    IMCOMPLETE("Incompleto"),
    COMPLETE("Completo");

    private String label;

    GameStatusEnum(final String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }


}
