
package br.com.stefanini.servicos.cadastros.enterprise.ejb.cadastro;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pessoa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pessoa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cpf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtAtualizacaoCadastro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtCadastro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtNascimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nacionalidade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="naturalidade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pessoa", propOrder = {
    "cpf",
    "dtAtualizacaoCadastro",
    "dtCadastro",
    "dtNascimento",
    "email",
    "idPessoa",
    "nacionalidade",
    "naturalidade",
    "nome",
    "sexo"
})
public class Pessoa {

    protected String cpf;
    protected String dtAtualizacaoCadastro;
    protected String dtCadastro;
    protected String dtNascimento;
    protected String email;
    protected String idPessoa;
    protected String nacionalidade;
    protected String naturalidade;
    protected String nome;
    protected String sexo;

    /**
     * Gets the value of the cpf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Sets the value of the cpf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCpf(String value) {
        this.cpf = value;
    }

    /**
     * Gets the value of the dtAtualizacaoCadastro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtAtualizacaoCadastro() {
        return dtAtualizacaoCadastro;
    }

    /**
     * Sets the value of the dtAtualizacaoCadastro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtAtualizacaoCadastro(String value) {
        this.dtAtualizacaoCadastro = value;
    }

    /**
     * Gets the value of the dtCadastro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtCadastro() {
        return dtCadastro;
    }

    /**
     * Sets the value of the dtCadastro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtCadastro(String value) {
        this.dtCadastro = value;
    }

    /**
     * Gets the value of the dtNascimento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtNascimento() {
        return dtNascimento;
    }

    /**
     * Sets the value of the dtNascimento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtNascimento(String value) {
        this.dtNascimento = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the idPessoa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPessoa() {
        return idPessoa;
    }

    /**
     * Sets the value of the idPessoa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPessoa(String value) {
        this.idPessoa = value;
    }

    /**
     * Gets the value of the nacionalidade property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNacionalidade() {
        return nacionalidade;
    }

    /**
     * Sets the value of the nacionalidade property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNacionalidade(String value) {
        this.nacionalidade = value;
    }

    /**
     * Gets the value of the naturalidade property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaturalidade() {
        return naturalidade;
    }

    /**
     * Sets the value of the naturalidade property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaturalidade(String value) {
        this.naturalidade = value;
    }

    /**
     * Gets the value of the nome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the value of the nome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNome(String value) {
        this.nome = value;
    }

    /**
     * Gets the value of the sexo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Sets the value of the sexo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSexo(String value) {
        this.sexo = value;
    }

}
