package br.fepi.si.model;


public enum Estilo {
	
	PEITO("Peito"),
	COSTA("Costa"), 
	BORBOLETA("Borboleta");
	
    
    private String descricao;

    private Estilo(String descricao) {
    
        this.descricao = descricao;
        
    }
}
