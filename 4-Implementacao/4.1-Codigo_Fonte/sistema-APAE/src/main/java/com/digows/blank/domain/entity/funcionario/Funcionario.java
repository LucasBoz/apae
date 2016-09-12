/**
 * 
 */
package com.digows.blank.domain.entity.funcionario;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.directwebremoting.annotations.DataTransferObject;
import org.hibernate.envers.Audited;
import org.springframework.util.Assert;

import com.digows.blank.domain.entity.pessoa.Endereco;
import com.digows.blank.domain.entity.pessoa.Pessoa;

/**
 * @author lucas
 *
 */

/**
 * @author lucas
 *
 */
@Entity
@Audited
@DataTransferObject(javascript = "Funcionario")
public class Funcionario extends Pessoa implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4577097521894994679L;

	@Column(length = 100)
	private String nomePai;
	

	@Column(length = 12)
	private String codigoInep;

	@Column(length = 100)
	private String nomeMae;

	@Column(length = 100)
	private String email;

	@Column(length = 100)
	private String numeroIdentificacaoSocial;

	@Column(length = 100)
	private Escolaridade escolaridade;

	@Column(length = 100)
	private TipoDeficiencia tipoDeficiencia;

	@Column(length = 100)
	private Cor cor;

	
    @ElementCollection( targetClass= CursosEspecificos.class, fetch= FetchType.EAGER )
    @CollectionTable(name = "funcionario_curso_especificos", joinColumns = @JoinColumn(name = "funcionario_id"))
    @Column(nullable = false, name= "curso_especifico")
    @Enumerated( EnumType.ORDINAL )
    private Set<CursosEspecificos> CursosEspecificos = new HashSet<>();
    
    @ElementCollection( targetClass= Funcao.class, fetch= FetchType.EAGER )
    @CollectionTable(name = "funcionario_funcao", joinColumns = @JoinColumn(name = "funcionario_id"))
    @Column(nullable = false, name= "funcao")
    @Enumerated( EnumType.ORDINAL )
    private Set<Funcao> Funcao = new HashSet<>();
    
	
	@OneToOne( cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	private Endereco endereco;
	
	@OneToOne( cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	private Endereco localNascimento;
	
	
	@OneToMany( fetch = FetchType.EAGER, cascade= CascadeType.ALL )
	@JoinColumn(name="pessoa_id")
	private List<Formacao> formacoes;
	
	
	
	/**
	 * @return the cursosEspecificos
	 */
	public Set<CursosEspecificos> getCursosEspecificos()
	{
		return CursosEspecificos;
	}



	/**
	 * @param cursosEspecificos the cursosEspecificos to set
	 */
	public void setCursosEspecificos( Set<CursosEspecificos> cursosEspecificos )
	{
		CursosEspecificos = cursosEspecificos;
	}

	
	
	/**
	 * @return the escolaridade
	 */
	public Escolaridade getEscolaridade()
	{
		return escolaridade;
	}



	/**
	 * @param escolaridade the escolaridade to set
	 */
	public void setEscolaridade( Escolaridade escolaridade )
	{
		this.escolaridade = escolaridade;
	}



	/**
	 * @return the tipodeficiencia
	 */
	public TipoDeficiencia getTipoDeficiencia()
	{
		return tipoDeficiencia;
	}



	/**
	 * @param tipodeficiencia the tipodeficiencia to set
	 */
	public void setTipoDeficiencia( TipoDeficiencia tipoDeficiencia )
	{
		this.tipoDeficiencia = tipoDeficiencia;
	}



	/**
	 * @return the cor
	 */
	public Cor getCor()
	{
		return cor;
	}



	/**
	 * @param cor the cor to set
	 */
	public void setCor( Cor cor )
	{
		this.cor = cor;
	}






	/**
	 * @return the funcao
	 */
	public Set<Funcao> getFuncao()
	{
		return Funcao;
	}



	/**
	 * @param funcao the funcao to set
	 */
	public void setFuncao( Set<Funcao> funcao )
	{
		Funcao = funcao;
	}



	/**
	 * @return the endereco
	 */
	public Endereco getEndereco()
	{
		return endereco;
	}



	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco( Endereco endereco )
	{
		this.endereco = endereco;
	}



	/**
	 * @return the localNascimento
	 */
	public Endereco getLocalNascimento()
	{
		return localNascimento;
	}



	/**
	 * @param localNascimento the localNascimento to set
	 */
	public void setLocalNascimento( Endereco localNascimento )
	{
		this.localNascimento = localNascimento;
	}



	/**
	 * @return the formacoes
	 */
	public List<Formacao> getFormacoes()
	{
		return formacoes;
	}



	/**
	 * @param formacoes the formacoes to set
	 */
	public void setFormacoes( List<Formacao> formacoes )
	{
		this.formacoes = formacoes;
	}



	/**
	 * @return the nomePai
	 */
	public String getNomePai()
	{
		return nomePai;
	}



	/**
	 * @param nomePai the nomePai to set
	 */
	public void setNomePai( String nomePai )
	{
		this.nomePai = nomePai;
	}



	/**
	 * @return the nomeMae
	 */
	public String getNomeMae()
	{
		return nomeMae;
	}



	/**
	 * @param nomeMae the nomeMae to set
	 */
	public void setNomeMae( String nomeMae )
	{
		this.nomeMae = nomeMae;
	}



	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}



	/**
	 * @param email the email to set
	 */
	public void setEmail( String email )
	{
		this.email = email;
	}



	/**
	 * @return the numeroIdentificacaoSocial
	 */
	public String getNumeroIdentificacaoSocial()
	{
		return numeroIdentificacaoSocial;
	}

	/**
	 * @param numeroIdentificacaoSocial the numeroIdentificacaoSocial to set
	 */
	public void setNumeroIdentificacaoSocial( String numeroIdentificacaoSocial )
	{
		this.numeroIdentificacaoSocial = numeroIdentificacaoSocial;
	}



}
