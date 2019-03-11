package br.com.cursojsf.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIOutput;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name = "jogoDaVelhaBean")
@ViewScoped
public class JogoDaVelhaBean {
	
	private Boolean fimDoJogo = false;
	
	private String nmJogadorUm = "";
	private String nmJogadorDois = "";
	
	private String nmJogadorAtual = "";
	private String valorQueSeraJogado = "0";
	
	private String p11 = "";
	private String p12 = "";
	private String p13 = "";
	
	private String p21 = "";
	private String p22 = "";
	private String p23 = "";
	
	private String p31 = "";
	private String p32 = "";
	private String p33 = "";
	
	
	public void novoJogo() {
		this.nmJogadorUm = "";
		this.nmJogadorDois = "";
		
		this.p11 = "";
		this.p12 = "";
		this.p13 = "";
		
		this.p21 = "";
		this.p22 = "";
		this.p23 = "";
		
		this.p31 = "";
		this.p32 = "";
		this.p33 = "";
		
		this.fimDoJogo = false;
	}
	
	public String init() {
		nmJogadorUm = "";
		nmJogadorDois = "";
		valorQueSeraJogado = "0";
		p11 = "";
		
		return "jogoDaVelha";
	}
	
	public String onChangeNmJogadorUm(ValueChangeEvent event) {
		this.nmJogadorUm = event.getNewValue().toString();
		
		if( this.valorQueSeraJogado.equals("0") ) {
			this.nmJogadorAtual = this.nmJogadorUm;
		}
		
		return this.nmJogadorUm;
	}
	
	public String onChangeNmJogadorDois(ValueChangeEvent event) {
		this.nmJogadorDois = event.getNewValue().toString();
		
		if( this.valorQueSeraJogado.equals("X") ) {
			this.nmJogadorAtual = this.nmJogadorDois;
		}
		
		return this.nmJogadorDois;
	}
	
	public void trocaJogador(String valorPreenchido) {
		
		if( valorPreenchido.equals("0") ) {
			this.valorQueSeraJogado = "X";
		} else {
			this.valorQueSeraJogado = "0";
		}
		
		this.jogoFoiFinalizado();
	}
	
	public void onChangeItemTabuleiroP11() {
		
		this.p11 = this.getValorQueSeraJogado();
		
		this.trocaJogador(this.p11);
		 
	}
	
	public void onChangeItemTabuleiroP12() {
		
		this.p12 = this.getValorQueSeraJogado();
		
		this.trocaJogador(this.p12);
		 
	}
	
	public void onChangeItemTabuleiroP13() {
		
		this.p13 = this.getValorQueSeraJogado();
		
		this.trocaJogador(this.p13);
		
	}
	
	public void onChangeItemTabuleiroP21() {
		
		this.p21 = this.getValorQueSeraJogado();
		
		this.trocaJogador(this.p21);
		
	}
	
	public void onChangeItemTabuleiroP22() {
		
		this.p22 = this.getValorQueSeraJogado();
		
		this.trocaJogador(this.p22);
		
	}
	
	public void onChangeItemTabuleiroP23() {
		
		this.p23 = this.getValorQueSeraJogado();
		
		this.trocaJogador(this.p23);
		
	}
	
public void onChangeItemTabuleiroP31() {
		
		this.p31 = this.getValorQueSeraJogado();
		
		this.trocaJogador(this.p31);
		
	}
	
	public void onChangeItemTabuleiroP32() {
		
		this.p32 = this.getValorQueSeraJogado();
		
		this.trocaJogador(this.p32);
		
	}
	
	public void onChangeItemTabuleiroP33() {
		
		this.p33 = this.getValorQueSeraJogado();
		
		this.trocaJogador(this.p33);
		
	}
	
	public Boolean jogoFoiFinalizado() {
		
		Boolean result = false;
		
		// ***************** Comparando as linhas iguais ************************** //
		if( this.p11.equals( this.p12 ) && this.p11.equals( this.p13) && !this.p11.equals("") ) {
			
			result = true;
		}
		
		if( this.p21.equals( this.p22 ) && this.p21.equals( this.p23)  && !this.p21.equals("") ) {
			
			result = true;
		}
		
		if( this.p31.equals( this.p32 ) && this.p31.equals( this.p33)  && !this.p31.equals("") ) {
			
			result = true;
		}
		
		// ***************** Comparando as Colunas iguais ************************** //
		if( this.p11.equals( this.p21 ) && this.p11.equals( this.p31)  && !this.p11.equals("") ) {
			
			result = true;
		}
		
		if( this.p12.equals( this.p22 ) && this.p12.equals( this.p32)  && !this.p12.equals("") ) {
			
			result = true;
		}
		
		if( this.p13.equals( this.p23 ) && this.p13.equals( this.p33)  && !this.p13.equals("") ) {
			
			result = true;
		}
		
		// ***************** Comparando as diagnonais ************************** //
		if( this.p11.equals( this.p22 ) && this.p11.equals( this.p33) && !this.p11.equals("") ) {
			
			result = true;
		}
		
		if( this.p13.equals( this.p22 ) && this.p13.equals( this.p31)  && !this.p13.equals("")) {
			
			result = true;
		}
		
		this.fimDoJogo = result;
		
		if( this.fimDoJogo) {
			this.nmJogadorAtual += "( VENCEDOR )";			
		}
		
		return result;
		
	}

	
	//GETS E SETS
	public String getNmJogadorUm() {
		return nmJogadorUm;
	}

	public void setNmJogadorUm(String nmJogadorUm) {
		this.nmJogadorUm = nmJogadorUm;
	}

	public String getNmJogadorDois() {
		return nmJogadorDois;
	}

	public void setNmJogadorDois(String nmJogadorDois) {
		this.nmJogadorDois = nmJogadorDois;
	}

	public String getNmJogadorAtual() {
		return nmJogadorAtual;
	}

	public void setNmJogadorAtual(String nmJogadorAtual) {
		this.nmJogadorAtual = nmJogadorAtual;
	}

	public String getP11() {
		return p11;
	}

	public void setP11(String p11) {
		this.p11 = p11;
	}

	public String getValorQueSeraJogado() {
		
		String result = "";
		
		if( !this.fimDoJogo ) {
			result = valorQueSeraJogado;
		}
		
		return result;
	}

	public void setValorQueSeraJogado(String valorQueSeraJogado) {
		this.valorQueSeraJogado = valorQueSeraJogado;
	}

	public String getP12() {
		return p12;
	}

	public void setP12(String p12) {
		this.p12 = p12;
	}

	public String getP13() {
		return p13;
	}

	public void setP13(String p13) {
		this.p13 = p13;
	}

	public String getP21() {
		return p21;
	}

	public void setP21(String p21) {
		this.p21 = p21;
	}

	public String getP22() {
		return p22;
	}

	public void setP22(String p22) {
		this.p22 = p22;
	}

	public String getP23() {
		return p23;
	}

	public void setP23(String p23) {
		this.p23 = p23;
	}

	public String getP31() {
		return p31;
	}

	public void setP31(String p31) {
		this.p31 = p31;
	}

	public String getP32() {
		return p32;
	}

	public void setP32(String p32) {
		this.p32 = p32;
	}

	public String getP33() {
		return p33;
	}

	public void setP33(String p33) {
		this.p33 = p33;
	}

	public Boolean getFimDoJogo() {
		return fimDoJogo;
	}

	public void setFimDoJogo(Boolean fimDoJogo) {
		this.fimDoJogo = fimDoJogo;
	}
	
	

	
	 
}