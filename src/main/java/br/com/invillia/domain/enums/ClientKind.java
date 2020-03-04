package br.com.invillia.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ClientKind {

    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2, "Pessoa Jurídica");

    private int code;
    private String description;

    public static ClientKind toEnum(Integer code){

        if(code == null){
            return null;
        }

        for(ClientKind clientKind : ClientKind.values()){
            if(code.equals(clientKind.getCode())){
                return clientKind;
            }
        }

        throw new IllegalArgumentException("Id inválido: "+code);
    }
}
