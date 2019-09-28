/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorLexico_modelo;

/**
 *
 * @author Pepe
 */
public enum TipoLexemaEnum {    
    
    
    
    PR_MAIN,
    
    STR_IMPR,
    STR_ENTR,
    
    EST_SI,
    EST_SINO,
    EST_PARA,
    EST_PARA_CADA,
    EST_MIENTRAS,
    EST_HACER,
    
    TIPO_DATO_VAR,
    TIPO_DATO_ENT,
    TIPO_DATO_DEC,
    TIPO_DATO_CAD,
    TIPO_DATO_CAR,
    TIPO_DATO_BOL,
    
    OPE_SUMA,
    OPE_RESTA,
    OPE_MULTIPLICACION,
    OPE_DIVISION,
    OPE_MODULO,
    
    OPE_ASIG_SUMA,
    OPE_ASIG_MULTIPLICACION,
    OPE_ASIG_RESTA,
    OPE_ASIG_DIVISION,
    OPE_ASIG_IGUAL,
    
    OPE_ESP_SUMA,
    OPE_ESP_RESTA,
    
    OPE_REL_MAYOR,
    OPE_REL_MENOR,
    OPE_REL_MAYOR_IGUAL,
    OPE_REL_MENOR_IGUAL,
    OPE_REL_IGUAL_IGUAL,
    OPE_REL_DIFERENTE,
    
    VLR_RETORNO,
    VLR_ROMPER,
    VLR_CONTINUAR,
    VLR_NULO,
    
    XML,
    JSON,
    CAST_CONVERTIR,
    
    HTTP,
    HTTP_CONECTAR,
    HTTP_OPCIONES,
    
    VERBO_HTTP_GET,
    VERBO_HTTP_POST,
    VERBO_HTTP_PUT,
    VERBO_HTTP_PATCH,
    VERBO_HTTP_DELETE,
    
    REQUEST_TRAER_CODIGO,
    REQUEST_TRAER_NOMBRE,
    REQUEST_TRAER_MENSAJE,
    REQUEST_TRAER_CUERPO,
    REQUEST_TRAER_VALOR,
    REQUEST_CAMPOS,
    REQUEST_PARAMETROS,
    REQUEST_RESPUESTA,
    
    VLR_VERDADERO,
    VLR_FALSO,
    
    VALOR_CADENA,
    VALOR_NUMERICO,
    
    COMENTARIO,
    DEFINICION_METODO,
    IDENTIFICADOR,
    
    PUNTO_Y_COMA,
    PUNTO,
    COMA,
    DOS_PUNTOS,
    BACK_SLASH_ESCAPE,
    PARENTESIS_ABIERTO,
    PARENTESIS_CERRADO,
    LLAVE_ABIERTA,
    LLAVE_CERRADA,
    COMILLA_DOBLE,
    
}
